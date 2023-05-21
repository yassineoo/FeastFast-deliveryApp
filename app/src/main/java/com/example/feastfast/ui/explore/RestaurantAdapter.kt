package com.example.feastfast.ui.explore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.marginBottom
import androidx.core.view.setMargins

import androidx.recyclerview.widget.RecyclerView

import com.example.feastfast.databinding.ListItemRestaurantBinding
import com.example.feastfast.models.Restaurant
import com.example.feastfast.ui.restaurant.RestaurantActivity

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
            textRestaurantName.text = data[position].name
            imageRestaurant.setImageResource(data[position].picture)
            textRating.text = data[position].averageRating.toString()
            textCuisine.text =  data[position].cuisineType
            textAddress.text = data[position].locationAddress
            viewCardContent.setOnClickListener {
                    val intent = Intent(context , RestaurantActivity::class.java)
                    intent.putExtra("Restaurant",data[position])
                    context.startActivity(intent)
            }
            if (position==data.size-1){
            val params =root.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(0,0,0,550)
            }

        }
    }


    class RestaurantListItemViewHolder(val binding: ListItemRestaurantBinding) : RecyclerView.ViewHolder(binding.root)
}