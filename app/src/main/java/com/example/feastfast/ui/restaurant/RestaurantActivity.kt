package com.example.feastfast.ui.restaurant

import android.content.Intent
import android.opengl.GLES30
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.feastfast.R
import com.example.feastfast.databinding.ActivityCartBinding
import com.example.feastfast.databinding.ActivityRestaurantBinding
import com.example.feastfast.ui.cart.CartActivity
import com.example.feastfast.ui.login.loginAdapter
import com.google.android.material.tabs.TabLayout

class RestaurantActivity : AppCompatActivity() {
    private var tabLayout: TabLayout? = null
    private var viewPager2: ViewPager2? = null
    private var adapter: RestaurantMenuAdapter? = null
    lateinit var binding: ActivityRestaurantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRestaurantBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
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

        binding.resLogo.setOnClickListener {
            val intent = Intent(this,CartActivity::class.java)
            this.startActivity(intent)
        }
        binding.floatingCartButton.setOnClickListener {
            val intent = Intent(this,CartActivity::class.java)
            this.startActivity(intent)
        }
        binding!!.gps.setOnClickListener {
            val intent = Intent(this,RestaurantActivity::class.java)
            intent.putExtra("Username", "John Doe")
            this.startActivity(intent)
        }

    }


    fun getCategories(id: Int) : List<String>{
        val data = mutableListOf<String>()
        data.add("pizza")
        data.add("tacos")
        return data
    }

}