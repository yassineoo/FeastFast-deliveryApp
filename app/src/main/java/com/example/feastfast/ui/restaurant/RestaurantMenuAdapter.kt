package com.example.feastfast.ui.restaurant

import com.example.feastfast.ui.login.loginFragment
import com.example.feastfast.ui.login.signupFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import androidx.viewpager2.adapter.FragmentStateAdapter

class RestaurantMenuAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {


    override fun createFragment(position: Int): Fragment {

         return RestaurantMenuFragment()

    }

    override fun getItemCount(): Int = 4

}
