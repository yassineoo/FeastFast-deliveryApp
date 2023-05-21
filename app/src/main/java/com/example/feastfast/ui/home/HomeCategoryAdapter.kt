package com.example.feastfast.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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
            viewCardContent.setBackgroundColor(ContextCompat.getColor(context,data[position].color))
            if (position==data.size-1){
                val params =root.layoutParams as ViewGroup.MarginLayoutParams
                params.setMargins(0,0,50,0)
            }
        }

    }
}