package com.example.feastfast.models.retrofit

import com.example.feastfast.models.*
import com.example.feastfast.util.url
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Endpoint {
    @GET("res")
    suspend fun getAllRestaurants() : Response<List<Restaurant>>

    @GET("res/{id}/menu")
    suspend fun getRestaurantById(@Path("id") id: Int) : Response<List<MenuItem>>


    @POST("users/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<User>

    @POST("users/register")
    suspend fun register(
        @Body registerRequest: RegisterRequest
    ): Response<User>

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