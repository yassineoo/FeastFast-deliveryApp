package com.example.feastfast.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.feastfast.databinding.FragmentHomeBinding
import com.example.feastfast.ui.login.LoginActivity
import com.example.feastfast.ui.restaurant.RestaurantActivity


class HomeFragment : Fragment() {

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
    }
}