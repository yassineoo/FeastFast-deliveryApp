package com.example.feastfast.models

import okhttp3.MultipartBody
import okhttp3.RequestBody


data class RegisterRequest(
    val name: RequestBody,
    val email: RequestBody,
    val phone_number : RequestBody,
    val password: RequestBody,
    val registration_type :RequestBody,
    val pic : MultipartBody.Part
)

