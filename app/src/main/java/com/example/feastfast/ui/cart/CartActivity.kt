package com.example.feastfast.ui.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feastfast.databinding.ActivityCartBinding
import com.example.feastfast.databinding.ActivityRestaurantBinding
import com.example.feastfast.ui.restaurant.RestaurantMenuAdapterData

class CartActivity : AppCompatActivity() {
    lateinit var binding: ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //binding.recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        binding.CartRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.CartRecyclerView.adapter = CartAdapter(getCategories(1),this)

    }

    fun getCategories(id: Int) : List<String>{
        val data = mutableListOf<String>()
        data.add("pizza")
        data.add("tacos")
        return data
    }

}