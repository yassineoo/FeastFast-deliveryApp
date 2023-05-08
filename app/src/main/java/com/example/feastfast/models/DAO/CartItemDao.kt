package com.example.feastfast.models.DAO

import androidx.room.*
import com.example.feastfast.models.CartItem

@Dao
interface CartItemDao {

    @Insert
    fun addToCart(vararg items: CartItem)

    @Delete
    fun deleteFromCart(cartItem: CartItem)

    @Update
    fun updateItem(cartItem: CartItem)

    @Query("Delete FROM cartItems")
    fun emptyCart()

    @Query("SELECT * FROM cartItems")
    fun getCartContents() : List<CartItem>

    @Query("SELECT restaurantId from cartItems ")
    fun getCurrentRestaurant() : List<Int>
}