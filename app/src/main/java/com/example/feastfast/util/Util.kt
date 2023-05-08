package com.example.feastfast.util

class Util {
    fun sizeToPriceMultiplier(size: String) = when(size.uppercase()){
        "L" -> 1.0
        "XL"-> 1.75
        "XXL" -> 2.25
        else -> 1.0
    }
}