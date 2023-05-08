package com.example.feastfast.ui.cart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.feastfast.databinding.ActivityCartBinding
import com.example.feastfast.databinding.ListItemCartBinding
import com.example.feastfast.models.AppDatabase
import com.example.feastfast.models.CartItem
import com.example.feastfast.ui.restaurant.RestaurantActivity

class CartActivity : AppCompatActivity() {
    lateinit var binding: ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val linearLayout = binding.linearLayout2
        val addButton = binding.buttonAddMoreItems
        val items : List<CartItem> = AppDatabase.getInstance(this)!!.getMenuItemDao().getCartContents()
        var foodBill = 0.0
        val deliveryBill = 250.0
        for (item in items){
            foodBill+=item.getTotalPrice()
            val itemBinding: ListItemCartBinding = ListItemCartBinding.inflate(layoutInflater)
            itemBinding.imageItem.setImageResource(item.image)
            itemBinding.textNumberOfItems.text=item.quantity.toString()
            itemBinding.textName.text=item.name
            itemBinding.textPrice.text=item.getTotalPrice().toString()
            itemBinding.textSize.text=item.size
            val newItemView : View = itemBinding.root
            linearLayout.addView(newItemView)
        }

        //Bill logic start
        binding.textDeliveryPrice.text= "$deliveryBill DZD"
        binding.textFoodPrice.text= "$foodBill DZD"
        binding.textTotalBill.text=(deliveryBill+foodBill).toString()+" DZD"
        //end

        val emptyCartButton = binding.buttonEmptyCart
        emptyCartButton.setOnClickListener{
            AppDatabase.getInstance(this)!!.getMenuItemDao().emptyCart()
            linearLayout.removeAllViews()
            Toast.makeText(this,"cart empty!!" , Toast.LENGTH_SHORT).show()
        }

        addButton.setOnClickListener {
            val intent = Intent(this, RestaurantActivity::class.java)
            this.startActivity(intent)
        }
    }

}