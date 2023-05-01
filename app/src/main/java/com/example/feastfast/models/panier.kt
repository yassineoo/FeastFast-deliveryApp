package com.example.movieexample

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class panier(
    @PrimaryKey
    val panId : Int,
    val food : String ,
    val qte : Int ,
    val priceUnite : Int
)
