package com.example.feastfast.ui.restaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentRestaurantMenuBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RestaurantMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaurantMenuFragment : Fragment() {

    var binding :FragmentRestaurantMenuBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRestaurantMenuBinding.inflate(inflater,container,false)
        val view = binding!!.root
        val bundle = arguments

        binding!!.RecycleViewMenu.layoutManager = LinearLayoutManager(requireActivity())
        binding!!.RecycleViewMenu.adapter = RestaurantMenuAdapterData(getCategories(2),requireActivity(),bundle!!.getString("nameCategorie"))
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