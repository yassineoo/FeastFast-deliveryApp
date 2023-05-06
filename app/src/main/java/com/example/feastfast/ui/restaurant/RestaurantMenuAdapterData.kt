package com.example.feastfast.ui.restaurant

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.feastfast.R
import com.example.feastfast.databinding.ResMenuItemBinding


class RestaurantMenuAdapterData(val data: List<String>, val context: Context,val name :String?="kook") :
    RecyclerView.Adapter<RestaurantMenuAdapterData.MenuItemViewHolder>() {

    class MenuItemViewHolder(val binding: ResMenuItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        return RestaurantMenuAdapterData.MenuItemViewHolder(
            ResMenuItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.binding.apply {
        menuItemPrice.text = name
            cardMenuItem.setOnClickListener {
                it.findNavController().navigate(R.id.action_restaurantFragment_to_menuItemDetailsFragment)
            }
        }
    }
}