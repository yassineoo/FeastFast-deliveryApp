package com.example.feastfast.ui.restaurant

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.feastfast.databinding.FragmentRestaurantBinding
import com.example.feastfast.models.MenuItem
import com.example.feastfast.models.Restaurant
import com.example.feastfast.models.retrofit.Endpoint
import com.example.feastfast.models.room.AppDatabase
import com.example.feastfast.ui.cart.CartActivity
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.*

class RestaurantFragment : Fragment() {

    lateinit var binding : FragmentRestaurantBinding
    lateinit var myContext: FragmentActivity
    private var tabLayout: TabLayout? = null
    private var viewPager2: ViewPager2? = null
    private var adapter: RestaurantMenuAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Retrieve the Restaurant object from arguments
        var restaurant = arguments?.getSerializable("restaurant") as? Restaurant
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")

        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        print(restaurant)
        print("x is  ---------------------------------------------------------------------------")
        print("x is  ---------------------------------------------------------------------------")
        binding = FragmentRestaurantBinding.inflate(inflater,container,false)
        val view = binding.root
        return  view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myContext = requireActivity()
        tabLayout =binding.tabLayout
        viewPager2 = binding.viewPager


        val activity = activity as RestaurantActivity



        // Retrieve the Restaurant object from arguments
        val restaurant = activity.getRestaurant()


        setResInfo(restaurant)

        binding.viewCartButton.setOnClickListener {
            val intent = Intent(myContext, CartActivity::class.java)
            myContext.startActivity(intent)
            myContext.finish()

        }

        val buttonBack = binding.resBackIcon
        buttonBack.setOnClickListener {
            myContext.finish()

        }



        loadData()

    }

    override fun onResume() {
        super.onResume()
        //making see cart contents button visible if there are items in the cart
        val items = AppDatabase.getInstance(myContext)!!.getMenuItemDao().getCartContents()
        val isFilled = items.isNotEmpty()
        val viewCartButton = binding.viewCartButton
        viewCartButton.visibility = if(isFilled) View.VISIBLE else View.GONE
        //end of
        val numberOfItems = binding.textNumberOfItems
        numberOfItems.text=items.size.toString()

    }

    fun getCategories() : List<String>{
        val data = mutableListOf<String>()
        data.add("pizza")
        data.add("tacos")
        data.add("traditional")
        data.add("Deserts")
        data.add("Pizza")
        data.add("Tacos")
        return data
    }
    fun loadData(){
        var data : List<MenuItem>
        val exceptionHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            myContext.runOnUiThread {
                Toast.makeText(myContext, "Request failed: ${throwable.message}", Toast.LENGTH_LONG).show()
            }
        }
        CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
            // replace this with  getRestaurantById(restaurant.id)
            val response = Endpoint.createEndpoint().getRestaurantById(1)
            withContext(Dispatchers.Main) {



                if (response.isSuccessful && response.body() != null) {
                    data = response.body()!!.toList()
                    //
                         setupViewPagerAndTabLayout(data)
                 //   setupTabs(data)
                print(data)
                } else {
                    Toast.makeText(myContext, "Request unsuccessful!", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }


    fun setResInfo (res : Restaurant?) {
        binding.resName.text = res?.name
        binding.resCuisine.text = res?.cuisineType
        //binding.resImage = res.ima
      //  binding.res.text = res.name
        binding.gps.text = res?.locationAddress
      //binding.openTime.text = res.openTime

    }

   fun getDistinctCategories(apiResponse:  List<MenuItem>): Array<String> {
        return apiResponse!!.map { it.categorie }.distinct().toTypedArray()
    }










    private fun setupViewPagerAndTabLayout(apiResponse:  List<MenuItem>) {

        val categories: Array<String> = getDistinctCategories(apiResponse)

        // Remove all existing tabs
        binding.tabLayout.removeAllTabs()

        for (category in categories) {
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(category))
        }

        val adapter = RestaurantMenuAdapter(myContext, categories.toList(), apiResponse)
        viewPager2!!.adapter = adapter
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager2!!.currentItem = tab.position
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


}