package com.example.videoapplication.domain.repository

import arrow.core.Either
import com.example.videoapplication.domain.model.NetworkError
import com.example.videoapplication.domain.model.Product
import com.example.videoapplication.domain.model.ProductResult

interface ProductRepository {
    suspend fun getProduct(): Either<NetworkError, ProductResult>
    suspend fun getProductById(productId: String):Either<NetworkError, Product>
}