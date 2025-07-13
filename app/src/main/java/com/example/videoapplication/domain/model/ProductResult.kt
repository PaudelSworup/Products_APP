package com.example.videoapplication.domain.model

sealed class ProductResult {
    data class Remote(val products: List<Product>) : ProductResult()
    data class OfflineFallback(val products: List<Product>, val message:String) : ProductResult()
}