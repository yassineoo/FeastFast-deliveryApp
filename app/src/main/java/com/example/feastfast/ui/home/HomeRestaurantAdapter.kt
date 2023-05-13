package com.example.feastfast.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.feastfast.databinding.ListItemHomeRestaurantBinding

import com.example.feastfast.databinding.ListItemRestaurantBinding
import com.example.feastfast.models.Restaurant
import com.example.feastfast.ui.restaurant.RestaurantActivity

class HomeRestaurantAdapter(val data : List<Restaurant>, val context : Context) : RecyclerView.Adapter<HomeRestaurantAdapter.HomeRestaurantListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRestaurantListItemViewHolder {
        return HomeRestaurantAdapter.HomeRestaurantListItemViewHolder(
            ListItemHomeRestaurantBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: HomeRestaurantListItemViewHolder, position: Int) {
        holder.binding.apply {
            imageRestaurant.setImageResource(data[position].picture)
            textRating.text = data[position].averageRating.toString()
            textCuisine.text =  data[position].cuisineType
            textAddress.text = data[position].locationAddress
            viewCardContent.setOnClickListener {
                    val intent = Intent(context , RestaurantActivity::class.java)
                    context.startActivity(intent)

            }

        }
    }


    class HomeRestaurantListItemViewHolder(val binding: ListItemHomeRestaurantBinding) : RecyclerView.ViewHolder(binding.root)
}