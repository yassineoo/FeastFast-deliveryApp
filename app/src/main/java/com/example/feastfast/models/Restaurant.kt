package com.example.feastfast.models

import java.io.Serializable

data class Restaurant(
    val id:Int,
    val name:String,
    val logo:String,
    val picture : String,
    val locationAddress: String,
    val locationMapLong: Float,
    val locationMapLat: Float,
    val cuisineType: String,
    val opening_time :String ,
    val closing_time :String ,
    var averageRating: Float,
    val ratersCount:Int,
    val phoneNumber: String,
    val email: String,
    val instaLink: String,
    val fbLink: String,
    val isPreferred: Boolean?,
) : Serializable
