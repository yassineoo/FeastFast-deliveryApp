package com.example.feastfast.models.retrofit

import com.example.feastfast.models.Restaurant
import com.example.feastfast.util.url
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Endpoint {
    @GET("res")
    suspend fun getAllRestaurants() : Response<List<Restaurant>>

    companion object {
        var endpoint: Endpoint? = null
        fun createEndpoint(): Endpoint {
            if(endpoint ==null) {
                endpoint = Retrofit.Builder().baseUrl(url). addConverterFactory(GsonConverterFactory.create()).build(). create(Endpoint::class.java)
            }
            return endpoint!!
        }
    }

}