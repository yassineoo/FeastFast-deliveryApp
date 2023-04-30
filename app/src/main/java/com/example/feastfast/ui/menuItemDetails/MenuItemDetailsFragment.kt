package com.example.feastfast.ui.menuItemDetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentMenuItemDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuItemDetailsFragment : BottomSheetDialogFragment() {

    lateinit var binding : FragmentMenuItemDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuItemDetailsBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLeave.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_menuItemDetailsFragment_to_navigation_explore)
        }
    }

}