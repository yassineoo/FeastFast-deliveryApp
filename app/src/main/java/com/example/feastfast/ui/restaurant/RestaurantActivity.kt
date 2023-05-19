package com.example.feastfast.ui.restaurant

import android.content.Intent
import android.opengl.GLES30
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2
import com.example.feastfast.R
import com.example.feastfast.databinding.ActivityCartBinding
import com.example.feastfast.databinding.ActivityRestaurantBinding
import com.example.feastfast.models.Restaurant
import com.example.feastfast.ui.cart.CartActivity
import com.example.feastfast.ui.login.loginAdapter
import com.google.android.material.tabs.TabLayout

class RestaurantActivity : AppCompatActivity() {

    private var restaurant: Restaurant? = null
    lateinit var binding: ActivityRestaurantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRestaurantBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Retrieve the Restaurant object from intent extras
        restaurant = intent.getSerializableExtra("restaurant") as? Restaurant


        // Get the NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        // Get the NavController
        val navController = navHostFragment.navController

        // Pass the Restaurant object as an argument when navigating to the main fragment
        val bundle = Bundle()
        bundle.putSerializable("restaurant", restaurant)
        navController.setGraph(navController.graph, bundle)
    }
    public fun getRestaurant() : Restaurant? {
        return  intent.getSerializableExtra("restaurant") as? Restaurant ;
    }

}