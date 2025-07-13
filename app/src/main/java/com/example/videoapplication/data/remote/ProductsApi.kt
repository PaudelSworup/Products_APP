package com.example.videoapplication.data.remote

import com.example.videoapplication.domain.model.Product
import com.example.videoapplication.domain.repository.ProductRepository
import retrofit2.http.GET

interface ProductsApi {
//    @GET("products")
    suspend fun getProducts(): List<Product>

    suspend fun getProductById(productId:String): Product
}