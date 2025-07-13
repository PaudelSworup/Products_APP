package com.example.videoapplication.data.remote.core

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter


class ApiClient( val client: HttpClient,  val baseUrl:String) {
    suspend inline fun <reified T> get(
        endPoint: String,
        params: Map<String, Any>? = null,
    ): T {
        return client.get(baseUrl+endPoint){
            params?.forEach { (key,value)->
                parameter(key,value.toString())
            }
        }.body()

    }
}