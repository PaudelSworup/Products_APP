package com.example.videoapplication.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.videoapplication.domain.model.ProductDescViewState
import com.example.videoapplication.domain.model.ProductResult
import com.example.videoapplication.domain.model.ProductViewState
import com.example.videoapplication.domain.repository.ProductRepository
import com.example.videoapplication.presentation.viewModel.utils.sendEvent
import com.example.videoapplication.utils.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductsViewModel(private val productRepository: ProductRepository) : ViewModel() {
    private val _state = MutableStateFlow(ProductViewState())
    val state = _state.asStateFlow()

    private val _stateDesc = MutableStateFlow(ProductDescViewState())
    val stateDesc = _stateDesc.asStateFlow()

    init {
        getProducts()
    }


    fun getProducts() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }

            val result = productRepository.getProduct()
            result.onRight { productResult ->
                when (productResult) {
                    is ProductResult.Remote -> {
                        _state.update {
                            it.copy(
                                products = productResult.products,
                                isLoading = false
                            )
                        }
                    }

                    is ProductResult.OfflineFallback -> {
//                        if(false){
//                            sendEvent(Event.Toast("No internet. Showing offline data."))
//                            hasShownOfflineToast = false
//                        }
                        _state.update {
                            it.copy(
                                products = productResult.products,
                                isLoading = false
                            )
                        }
                    }

                }
            }.onLeft { error ->
                _state.update {
                    it.copy(error = error.error.message, isLoading = false)
                }

                sendEvent(Event.Toast(error.error.message))
            }
            _state.update { it.copy(isLoading = false) }
        }
    }


    fun getProductsById(productId: String) {
        viewModelScope.launch {
             _stateDesc.update { it.copy(isLoading = true) }

            productRepository.getProductById(productId).onRight { product->
                _stateDesc.update { it.copy(isLoading = false, selectedProduct = product) }
            }.onLeft { error-> _stateDesc.update { it.copy(error=error.error.message) }
                sendEvent(Event.Toast(error.error.message))
            }


        }
    }
}