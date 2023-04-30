package com.example.feastfast.ui.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feastfast.databinding.CartItemBinding
import com.example.feastfast.databinding.ResMenuItemBinding


class CartAdapter(val data: List<String>, val context: Context) :
    RecyclerView.Adapter<CartAdapter.MenuItemViewHolder>() {

    class MenuItemViewHolder(val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        return CartAdapter.MenuItemViewHolder(
            CartItemBinding.inflate(
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

        }
    }
}

