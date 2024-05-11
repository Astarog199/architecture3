package ru.gb.android.homework3.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.gb.android.homework3.presentation.product.di.ProductListComponent
import ru.gb.android.homework3.presentation.promo.di.PromoListComponent

@Component(modules = [
    NetworkModule::class,
    CoreModule::class,
    SubcomponentsModule::class
])
interface AppComponent {
    fun productListComponentFactory():ProductListComponent.Factory
    fun promoListComponentFactory(): PromoListComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}