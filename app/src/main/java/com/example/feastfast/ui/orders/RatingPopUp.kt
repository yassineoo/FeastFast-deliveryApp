package com.example.feastfast.ui.orders

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentRatingPopUpBinding


class RatingPopUp : DialogFragment() {

    lateinit var binding: FragmentRatingPopUpBinding
    lateinit var myContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRatingPopUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myContext= requireActivity()
        binding.buttonSubmit.backgroundTintList =  ColorStateList.valueOf( ContextCompat.getColor(myContext,R.color.primary_color)  )
        binding.buttonSubmit.setOnClickListener {
            Toast.makeText(context,"rated" , Toast.LENGTH_SHORT).show()
            dismiss()

        }

    }

}