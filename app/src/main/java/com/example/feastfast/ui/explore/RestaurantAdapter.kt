package com.example.feastfast.ui.explore

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.feastfast.R
import com.example.feastfast.databinding.ListItemRestaurantBinding
import com.example.feastfast.models.Restaurant

class RestaurantAdapter(val data : List<Restaurant> , val context : Context) : RecyclerView.Adapter<RestaurantAdapter.RestaurantListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListItemViewHolder {
        return RestaurantAdapter.RestaurantListItemViewHolder(
            ListItemRestaurantBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RestaurantListItemViewHolder, position: Int) {
        holder.binding.apply {
            imageRestaurant.setImageResource(data[position].picture)
            textRating.text = data[position].averageRating.toString()
            textCuisine.text =  data[position].cuisineType
            textAddress.text = data[position].locationAddress
            viewCardContent.setOnClickListener {
                it.findNavController().navigate(R.id.action_navigation_explore_to_menuItemDetailsFragment)
            }
        }
    }


    class RestaurantListItemViewHolder(val binding: ListItemRestaurantBinding) : RecyclerView.ViewHolder(binding.root)
}