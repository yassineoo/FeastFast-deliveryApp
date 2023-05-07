package com.example.feastfast.ui.restaurant

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.feastfast.R
import com.example.feastfast.databinding.ActivityRestaurantBinding
import com.example.feastfast.databinding.FragmentExploreBinding
import com.example.feastfast.databinding.FragmentRestaurantBinding
import com.example.feastfast.ui.cart.CartActivity
import com.example.feastfast.ui.explore.RestaurantAdapter
import com.google.android.material.tabs.TabLayout

class RestaurantFragment : Fragment() {

    lateinit var binding : FragmentRestaurantBinding
    private var tabLayout: TabLayout? = null
    private var viewPager2: ViewPager2? = null
    private var adapter: RestaurantMenuAdapter? = null
    var data = arrayOf("A","B","C")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRestaurantBinding.inflate(inflater,container,false)
        val view = binding.root
        return  view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabLayout =binding.tabLayout
        viewPager2 = binding.viewPager
        val cats = getCategories()
        for (x in cats) {
            tabLayout?.addTab(tabLayout?.newTab()!!.setText(x))
        }
        adapter = RestaurantMenuAdapter(requireActivity(),getCategories())
        viewPager2!!.setAdapter(adapter)
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager2!!.setCurrentItem(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        viewPager2!!.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout!!.selectTab(tabLayout!!.getTabAt(position))
            }
        })


        binding!!.viewCartButton.setOnClickListener {
            val intent = Intent(requireActivity(), CartActivity::class.java)
            requireActivity().startActivity(intent)

        }
    }

    fun getCategories() : List<String>{
        val data = mutableListOf<String>()
        data.add("pizza")
        data.add("tacos")
        data.add("traditionalle")
        data.add("7alwayat")
        data.add("pizza3")
        data.add("tacos4")
        data.add("traditionalle5")
        data.add("7alwayat2")
        return data
    }

}