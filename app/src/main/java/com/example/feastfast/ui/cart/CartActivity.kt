package com.example.feastfast.ui.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.feastfast.R
import com.example.feastfast.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {
    lateinit var binding: ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val linearLayout = binding.linearLayout2
        val addButton = binding.buttonAddMoreItems

        addButton.setOnClickListener {
            val newItem : View = layoutInflater.inflate(R.layout.list_item_cart, null)
            linearLayout.addView(newItem)
        }
    }

}