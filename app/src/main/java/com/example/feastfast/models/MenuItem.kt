package com.example.feastfast.models

data class MenuItem(
    val name : String,
    val image : String,
    val price : Double,
    val description: String,
    val restaurantId : Int,
    val categorie : String,
):java.io.Serializable{
    fun menuItemToCartItem(menuItem: MenuItem): CartItem{
        return CartItem(name = menuItem.name, image = 5, price = menuItem.price, restaurantId = menuItem.restaurantId)
    }
}
