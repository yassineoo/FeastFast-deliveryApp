package com.example.feastfast.models.retrofit

import com.example.feastfast.models.MenuItem
import com.example.feastfast.models.Order
import com.example.feastfast.models.Restaurant
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


const val url = "https://1377-41-220-149-75.ngrok-free.app/"

interface Endpoint {
    @GET("res")
    suspend fun getAllRestaurants() : Response<List<Restaurant>>

    @GET("res/{id}/menu")
    suspend fun getRestaurantById(@Path("id") id: Int) : Response<List<MenuItem>>

    @POST("orders/creatOrder")
    suspend fun sendOrder(
        @Body order: Order
    ): Response<Order>
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