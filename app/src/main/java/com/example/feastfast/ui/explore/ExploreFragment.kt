package com.example.feastfast.ui.explore

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentExploreBinding
import com.example.feastfast.models.Restaurant

class ExploreFragment : Fragment() {

    lateinit var binding : FragmentExploreBinding
    lateinit var myContext : Context
    lateinit var adapter: RestaurantAdapter
    lateinit var data : List<Restaurant>
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
        data = loadData()
        binding.recycleView.adapter= RestaurantAdapter(data,myContext)
        adapter = binding.recycleView.adapter as RestaurantAdapter


        val searchView = binding.searchView
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(queryText: String?): Boolean {
                search(queryText)
                return false
            }
            override fun onQueryTextChange(queryText: String?): Boolean {
                return false
            }
        })
    }

    fun loadData() : List<Restaurant> {
        return listOf(
            Restaurant(1,"HotSpot DZ 1",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant(2,"Pizzeria",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant(3,"sparTacos",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant(4,"bella",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant(5,"pizzalio",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz"),
            Restaurant(6,"tacosland",R.drawable.image_hotspot_logo2,R.drawable.image_hotspot,"7th street, view kouba", 0F,0F,"Mexican, portuguese",4.1F,"0550710721","hotspot@hotspot.dz","https://www.instagram.com/hotspot_dz/","https://web.facebook.com/HotSpotdz")
        )
    }

    fun getRestaurantById(id: Int) : Restaurant?{
        return loadData().find { it.id==id }
    }

    fun search(queryText:String?){
        if (queryText != null && queryText.isNotEmpty()){
            val filteredList = mutableListOf<Restaurant>()
            for(restaurant in data){
                if (restaurant.name.lowercase().contains(queryText.lowercase())){
                    filteredList.add(restaurant)
                }
            }

            if (filteredList.isNotEmpty()){
                adapter.setFilteredList(filteredList)
            }else{
                Toast.makeText(context,"No matches found" , Toast.LENGTH_SHORT).show()
                adapter.setFilteredList(data)
            }
        }
    }


}
