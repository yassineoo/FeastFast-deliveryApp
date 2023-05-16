package com.example.feastfast.models

import java.io.Serializable

data class Restaurant(
    val name:String,
    val logo:String,
    val picture : String,
    val locationAddress: String,
    val locationMapLong: Float,
    val locationMapLat: Float,
    val cuisineType: String,
    var averageRating: Float,
    val phoneNumber: String,
    val email: String,
    val instaLink: String,
    val fbLink: String
) : Serializable
