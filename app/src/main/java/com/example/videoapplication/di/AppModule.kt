package com.example.videoapplication.di

import com.example.videoapplication.data.remote.ProductsApi
import com.example.videoapplication.data.remote.api.ProductApiServiceImpl
import com.example.videoapplication.data.remote.core.ApiClient
import com.example.videoapplication.data.repository.ProductRepositoryImpl
import com.example.videoapplication.domain.repository.ProductRepository
import com.example.videoapplication.presentation.viewModel.ProductsViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

val appModule = module {
//    single {
//        Retrofit
//            .Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("https://fakestoreapi.com/")
//            .build()
//            .create(ProductsApi::class.java)
//    }

    single {
        HttpClient(Android){
            install(ContentNegotiation){gson()}
        }
    }

    single { ApiClient(get(), baseUrl = "https://fakestoreapi.com/") }

    single<ProductsApi> { ProductApiServiceImpl(get()) }

    single<ProductRepository> {
        ProductRepositoryImpl(get())
    }

    viewModel{ ProductsViewModel(get()) }




}