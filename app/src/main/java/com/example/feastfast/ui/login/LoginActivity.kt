package com.example.feastfast.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.feastfast.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class LoginActivity : AppCompatActivity() {

    private var tabLayout: TabLayout? = null
    private var viewPager2: ViewPager2? = null
    private var adapter: loginAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
        tabLayout?.addTab(tabLayout?.newTab()!!.setText("Login"))
        tabLayout?.addTab(tabLayout?.newTab()!!.setText("Register"))
        val fragmentManager: FragmentManager = supportFragmentManager
        adapter = loginAdapter(this)
        viewPager2!!.setAdapter(adapter)
        tabLayout!!.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager2!!.setCurrentItem(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        viewPager2!!.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout!!.selectTab(tabLayout!!.getTabAt(position))
            }
        })
    }
}

