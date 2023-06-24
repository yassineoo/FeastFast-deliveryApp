package com.example.feastfast.models

data class MenuItem(
    val name : String,
    val image : String,
    val price : Double,
    val description: String,
    var restaurantId : Int,
    val categorie : String,
    var restaurantName : String?,
):java.io.Serializable{
    fun menuItemToCartItem(menuItem: MenuItem): CartItem {
        return CartItem(
            name = menuItem.name,
            image = menuItem.image,
            price = menuItem.price,
            restaurantId = menuItem.restaurantId,
            restaurantName = if(menuItem.restaurantName!= null) menuItem.restaurantName else "default"
        )
    }
}
