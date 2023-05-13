package com.example.feastfast.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentHomeBinding
import com.example.feastfast.models.Category
import com.example.feastfast.models.Restaurant
import com.example.feastfast.ui.login.LoginActivity
import com.example.feastfast.ui.restaurant.RestaurantActivity
import com.google.android.material.imageview.ShapeableImageView


class HomeFragment : Fragment() {

    private lateinit var ad1 : ShapeableImageView;
    private lateinit var ad2 : ShapeableImageView;
    private lateinit var ad3: ShapeableImageView;

    private lateinit var viewPager2 : ViewPager2
    lateinit var myContext : FragmentActivity
    private val categories = listOf<Category>(
        Category(name = "Pizza",R.color.primary_color,R.drawable.image_category_pizza),
        Category(name = "Sandwich",R.color.pinkish,R.drawable.image_category_hotdog),
        Category(name = "Shawarma",R.color.brownish,R.drawable.image_category_shawarma),
        Category(name = "Cake",R.color.blackish,R.drawable.image_category_cake),
    )


    lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myContext = requireActivity()
        var images = listOf<Int>(R.drawable.image_hotspot,R.drawable.image_hotspot_logo,R.drawable.image_hotspot,R.drawable.image_hotspot_logo,R.drawable.image_hotspot);
        val adapter =  AdsViewPagerAdapter(images)
        binding.viewPager2.adapter = adapter
        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                changeColor()
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeColor()
            }

        })



        binding.recyclerViewCategories.layoutManager = LinearLayoutManager(myContext,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewFreeDelivery.layoutManager = LinearLayoutManager(myContext,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewNearYou.layoutManager = LinearLayoutManager(myContext,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewTopPastry.layoutManager = LinearLayoutManager(myContext,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewTopRated.layoutManager = LinearLayoutManager(myContext,LinearLayoutManager.HORIZONTAL,false)

        binding.recyclerViewCategories.adapter=HomeCategoryAdapter(categories,myContext)
        binding.recyclerViewFreeDelivery.adapter=HomeRestaurantAdapter(loadData(),myContext)
        binding.recyclerViewNearYou.adapter=HomeRestaurantAdapter(loadData(),myContext)
        binding.recyclerViewTopPastry.adapter=HomeRestaurantAdapter(loadData(),myContext)
        binding.recyclerViewTopRated.adapter=HomeRestaurantAdapter(loadData(),myContext)
    }

    fun loadData() : List<Restaurant> {
        return listOf(
            Restaurant("HotSpot DZ",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant("HotSpot DZ",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant("HotSpot DZ",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant("HotSpot DZ",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant("HotSpot DZ",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant("HotSpot DZ",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz")
        )
    }
    fun changeColor(){

        when (binding.viewPager2.currentItem){
            0 -> {
                binding.ind1.setBackgroundColor( getResources().getColor(R.color.addToCart))
                binding.ind2.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind3.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind4.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind5.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))

            }
            1 -> {
                binding.ind2.setBackgroundColor( getResources().getColor(R.color.addToCart))
                binding.ind1.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind3.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind4.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind5.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
            }
            2 -> {
                binding.ind3.setBackgroundColor( getResources().getColor(R.color.addToCart))
                binding.ind1.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind2.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind4.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind5.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))

            }

            3 -> {
                binding.ind4.setBackgroundColor( getResources().getColor(R.color.addToCart))
                binding.ind1.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind2.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind3.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind5.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))

            }
            5 -> {
                binding.ind5.setBackgroundColor( getResources().getColor(R.color.addToCart))
                binding.ind1.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind2.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind4.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding.ind3.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))

            }

        }

    }
}

