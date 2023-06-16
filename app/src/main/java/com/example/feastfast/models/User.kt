package com.example.feastfast.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class User(
    @PrimaryKey
    val id:Int,
    val name: String,
    val email: String,
    val phone_number : String,
    val password: String,
    val registration_type :String,
    val address :String?,
)
