package com.example.feastfast.models

data class Rating(
    val restaurantId : Int,
    val userId : Int,
    val rating: Int,
    val review : String,
)
