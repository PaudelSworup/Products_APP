package com.example.videoapplication.data.repository

import arrow.core.Either
import com.example.videoapplication.data.mapper.toNetworkError
import com.example.videoapplication.data.remote.ProductsApi
import com.example.videoapplication.domain.model.NetworkError
import com.example.videoapplication.domain.model.Product
import com.example.videoapplication.domain.model.ProductResult
import com.example.videoapplication.domain.repository.ProductRepository
import com.example.videoapplication.navigation.Screen

class ProductRepositoryImpl(private val productsApi: ProductsApi): ProductRepository {
    override suspend fun getProduct(): Either<NetworkError, ProductResult> {
        try{
            val products = productsApi.getProducts()
            return Either.Right(ProductResult.Remote(products = products))
        }catch (e: Exception){
            return Either.Left(e.toNetworkError())
        }
    }

    override suspend fun getProductById(productId: String): Either<NetworkError, Product> {
        try{
            val products = productsApi.getProductById(productId)
            return Either.Right(products)
        }catch (e: Exception){
            return Either.Left(e.toNetworkError())
        }
    }


}