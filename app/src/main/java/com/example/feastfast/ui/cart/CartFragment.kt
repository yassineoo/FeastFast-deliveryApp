package com.example.feastfast.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentCartBinding
import com.example.feastfast.databinding.FragmentRestaurantMenuBinding
import com.example.feastfast.ui.restaurant.RestaurantMenuAdapterData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {

    var binding : FragmentCartBinding ? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)
        val view = binding!!.root

        binding!!.CartRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding!!.CartRecyclerView.adapter = RestaurantMenuAdapterData(getCategories(2),requireActivity())
        // Inflate the layout for this fragment
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*
        binding?.button3?.setOnClickListener{
            it.findNavController().navigate(R.id.action_mainFragment_to_panierFragment)
        }
        */

    }
    fun getCategories(id: Int) : List<String>{
        val data = mutableListOf<String>()
        data.add("pizza")
        data.add("tacos")
        return data
    }

}