package com.example.feastfast.ui.restaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.feastfast.R
import com.example.feastfast.ui.login.loginAdapter
import com.google.android.material.tabs.TabLayout

class RestaurantActivity : AppCompatActivity() {
    private var tabLayout: TabLayout? = null
    private var viewPager2: ViewPager2? = null
    private var adapter: RestaurantMenuAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)
        val profileName = intent.getStringExtra("Username")
        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
        val cats = getCategories(1)
        for (x in cats) {
            tabLayout?.addTab(tabLayout?.newTab()!!.setText(x))
        }
        val fragmentManager: FragmentManager = supportFragmentManager
        adapter = RestaurantMenuAdapter(this)
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
    }

    fun getCategories(id: Int) : List<String>{
        val data = mutableListOf<String>()
        data.add("pizza")
        data.add("tacos")
        return data
    }

}