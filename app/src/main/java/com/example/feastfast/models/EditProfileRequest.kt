package com.example.feastfast.models

import okhttp3.MultipartBody
import okhttp3.RequestBody


data class EditProfileRequest(
    val id :Int ,
    val name: String,
    val email: String,
    val phone_number : String,
    val password: String,
 //   val pic : MultipartBody.Part
)

