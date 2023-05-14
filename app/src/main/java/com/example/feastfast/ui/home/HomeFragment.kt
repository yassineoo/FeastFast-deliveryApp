package com.example.feastfast.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentHomeBinding
import com.example.feastfast.ui.login.LoginActivity
import com.example.feastfast.ui.restaurant.RestaurantActivity


class HomeFragment : Fragment() {

    private lateinit var ad1 : ImageView;
    private lateinit var ad2 : ImageView;
    private lateinit var ad3: ImageView;

    private lateinit var viewPager2 : ViewPager2


    var binding : FragmentHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding!!.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.button.setOnClickListener {
            val intent = Intent(requireActivity(),RestaurantActivity::class.java)
            intent.putExtra("Username", "John Doe")
            requireActivity().startActivity(intent)
        }
        binding!!.loginbtn.setOnClickListener {
            val intent = Intent(requireActivity(),LoginActivity::class.java)
            intent.putExtra("Username", "John Doe")
            requireActivity().startActivity(intent)
        }
        var images = listOf<Int>(R.drawable.ad_one,R.drawable.ad2,R.drawable.ad3,R.drawable.ad4,R.drawable.ad5);
        val adapter =  AdsViewPagerAdapter(images)
        binding!!.viewPager2.adapter = adapter
        binding!!.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
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


    }
    fun changeColor(){

        when (binding!!.viewPager2.currentItem){
            0 -> {
                binding!!.ind1.setBackgroundColor( getResources().getColor(R.color.addToCart))
                binding!!.ind2.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind3.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind4.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind5.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))

            }
            1 -> {
                binding!!.ind2.setBackgroundColor( getResources().getColor(R.color.addToCart))
                binding!!.ind1.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind3.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind4.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind5.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
            }
            2 -> {
                binding!!.ind3.setBackgroundColor( getResources().getColor(R.color.addToCart))
                binding!!.ind1.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind2.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind4.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind5.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))

            }

            3 -> {
                binding!!.ind4.setBackgroundColor( getResources().getColor(R.color.addToCart))
                binding!!.ind1.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind2.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind3.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind5.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))

            }
            5 -> {
                binding!!.ind5.setBackgroundColor( getResources().getColor(R.color.addToCart))
                binding!!.ind1.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind2.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind4.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))
                binding!!.ind3.setBackgroundColor( getResources().getColor(R.color.addToCart_50_opacity))

            }

        }

}

}