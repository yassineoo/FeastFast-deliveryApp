package com.example.feastfast.ui.explore

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentExploreBinding
import com.example.feastfast.models.Restaurant
import com.example.feastfast.models.retrofit.Endpoint
import kotlinx.coroutines.*

class ExploreFragment : Fragment() {

    lateinit var binding : FragmentExploreBinding
    lateinit var myContext : FragmentActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExploreBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myContext= requireActivity()
        binding.recycleView.layoutManager = LinearLayoutManager(myContext)
        binding.recycleView.adapter= RestaurantAdapter(loadData(),myContext)
    }

    /*fun loadData() : List<Restaurant> {
        return listOf(
            Restaurant("HotSpot DZ",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant("HotSpot DZ",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant("HotSpot DZ",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant("HotSpot DZ",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant("HotSpot DZ",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant("HotSpot DZ",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz")
        )
    }*/
    fun loadData(): List<Restaurant>{
        var data : List<Restaurant> = listOf()
        val exceptionHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            myContext.runOnUiThread {
                Toast.makeText(myContext, "request successful with Some unspecified error", Toast.LENGTH_SHORT).show()
            }
        }
        CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
            val response = Endpoint.createEndpoint().getAllRestaurants()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful && response.body() != null) {
                    data = response.body()!!.toList()

                    print(data.size)
                } else {
                    Toast.makeText(myContext, "Request unsuccessful!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return data
    }

}
