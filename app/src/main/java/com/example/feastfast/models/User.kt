package com.example.feastfast.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class User(
    @PrimaryKey
    val id:Int,
    val name: String,
    val email: String,
    val phone_number : String,
    val password: String,
    val latitude :Double?,
    val longitude :Double?,
    val profile_picture :String? ,
    val social_media_id:String?,
    val registration_type :String,
    val address :String?,
) : Serializable
