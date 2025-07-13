package com.example.videoapplication.data.remote.api

import com.example.videoapplication.data.remote.ProductsApi
import com.example.videoapplication.data.remote.core.ApiClient
import com.example.videoapplication.domain.model.Product

class ProductApiServiceImpl(private val apiClient: ApiClient): ProductsApi {
    override suspend fun getProducts(): List<Product> {
       return apiClient.get("products")
    }

    override suspend fun getProductById(productId: String): Product {
        return apiClient.get("products/${productId}")
    }
}