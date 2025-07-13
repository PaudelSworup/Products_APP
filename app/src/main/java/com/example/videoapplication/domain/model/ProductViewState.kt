package com.example.videoapplication.domain.model

data class ProductViewState(val isLoading:Boolean = false, val products: List<Product> = emptyList(), val error: String?=null)
data class ProductDescViewState(val isLoading:Boolean = false,  val error: String?=null, val selectedProduct: Product? = null,)