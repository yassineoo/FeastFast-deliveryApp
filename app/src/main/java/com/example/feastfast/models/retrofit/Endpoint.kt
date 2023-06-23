package com.example.feastfast.models.retrofit

import com.example.feastfast.models.*
import com.example.feastfast.util.url
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path

interface Endpoint {
    @GET("res/{idUser}")
    suspend fun getAllRestaurants(@Path("idUser") idUser: Int) : Response<List<Restaurant>>
    @GET("res/fav/{idUser}")
    suspend fun  getFavRestaurants(@Path("idUser") idUser: Int) : Response<List<Restaurant>>


    @GET("res/{id}/menu")
    suspend fun getRestaurantById(@Path("id") id: Int) : Response<List<MenuItem>>


    @GET("users/{idUser}")
    suspend fun getUserProfile(@Path("idUser") idUser: Int) : Response<User>

    @GET("res/ratings/{idRes}")
    suspend fun getRestauranteRating(@Path("idRes") idRes: Int?) : Response<List<Int>>




    @GET("users/{idUser}/{idRes}")
    suspend fun favoriteRestaurant(@Path("idUser") idUser: Int , @Path("idRes") idRes: Int?  ) : Response<FavClickResponse>


    @POST("users/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<User>

    @Multipart
    @POST("users/edit")
    suspend fun editProfile(

        @Part userData: MultipartBody.Part,
        @Part file: MultipartBody.Part
    ):Response<User>
    /*
    @POST("users/register")
    suspend fun register(
        @Body registerRequest: RegisterRequest
    ): Response<User>
    */
    @Multipart
    @POST("users/register")
    suspend fun register(

        @Part userData: MultipartBody.Part,
        @Part file: MultipartBody.Part


    ):Response<User>

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