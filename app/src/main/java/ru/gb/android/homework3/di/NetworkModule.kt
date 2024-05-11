package ru.gb.android.homework3.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import ru.gb.android.homework3.data.product.ProductApiService
import ru.gb.android.homework3.data.product.ProductRemoteDataSource
import ru.gb.android.homework3.data.product.ProductRemoteDataSourceImpl
import ru.gb.android.homework3.data.promo.PromoApiService


@Module
object NetworkModule {
    private const val ENDPOINT = "https://makzimi.github.io/"

    @Provides
    fun provideProductApiService(
        retrofit: Retrofit
    ): ProductApiService {
        return retrofit.create(ProductApiService::class.java)
    }

    @Provides
    fun providePromoApiService(
        retrofit: Retrofit
    ): PromoApiService {
        return retrofit.create(PromoApiService::class.java)
    }

    private val Context.appDataStore: DataStore<Preferences> by preferencesDataStore(name = "app")

    @Provides
    fun provideLocalDataSource(
        context: Context
    ): DataStore<Preferences> {
        return context.appDataStore
    }

    @Provides
    fun provideProductRemoteDataSource(
        productApiService: ProductApiService,
    ): ProductRemoteDataSource {
        return ProductRemoteDataSourceImpl(
            productApiService = productApiService
        )
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideOkHttpClient(
        interceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return interceptor
    }
}
