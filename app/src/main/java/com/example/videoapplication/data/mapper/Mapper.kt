package com.example.videoapplication.data.mapper

import coil.network.HttpException
import com.example.videoapplication.domain.model.ApiError
import com.example.videoapplication.domain.model.NetworkError
import java.io.IOException

fun Throwable.toNetworkError(): NetworkError{
    val error = when(this){
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error=error,
        t=this
    )


}