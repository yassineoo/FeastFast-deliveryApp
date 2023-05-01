package com.example.feastfast.ui.restaurant

import android.content.Intent
import android.opengl.GLES30
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.feastfast.R
import com.example.feastfast.databinding.ActivityCartBinding
import com.example.feastfast.databinding.ActivityRestaurantBinding
import com.example.feastfast.ui.cart.CartActivity
import com.example.feastfast.ui.login.loginAdapter
import com.google.android.material.tabs.TabLayout

class RestaurantActivity : AppCompatActivity() {
    private var tabLayout: TabLayout? = null
    private var viewPager2: ViewPager2? = null
    private var adapter: RestaurantMenuAdapter? = null
    lateinit var binding: ActivityRestaurantBinding
    var data = arrayOf("A","B","C")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRestaurantBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

}