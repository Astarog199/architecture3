package ru.gb.android.homework3.data.product

interface ProductRemoteDataSource {
    suspend fun getProducts(): List<ProductDto>
}

class ProductRemoteDataSourceImpl(
    private val productApiService: ProductApiService,
) : ProductRemoteDataSource {
    override suspend fun getProducts(): List<ProductDto> {
        return productApiService.getProducts()
    }
}
