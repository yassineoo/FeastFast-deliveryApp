package com.example.feastfast.models

class Order (
    val user_id : Int,
    val restaurant_id: Int,
    val restaurantName:String,
    val order_status:String,
    val date : String,
    val time: String,
    val delivery_address: String,
    val totalPrice: Float,
    val isRated : Boolean
    )