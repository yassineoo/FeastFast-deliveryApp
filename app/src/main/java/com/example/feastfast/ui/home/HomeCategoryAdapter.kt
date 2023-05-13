package com.example.feastfast.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feastfast.databinding.ListItemHomeCategoryBinding
import com.example.feastfast.models.Category

class HomeCategoryAdapter(val data : List<Category>, val context : Context) : RecyclerView.Adapter<HomeCategoryAdapter.HomeCategoryViewHolder>() {
    class HomeCategoryViewHolder(val binding : ListItemHomeCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoryViewHolder {
        return HomeCategoryViewHolder(
            ListItemHomeCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: HomeCategoryViewHolder, position: Int) {
        holder.binding.apply {
            textCategory.text= data[position].name
            imageCategory.setImageResource(data[position].image)
            viewCardContent.setBackgroundColor(data[position].color)
        }
    }
}