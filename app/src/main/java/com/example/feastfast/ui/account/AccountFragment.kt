package com.example.feastfast.ui.account

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    var binding : FragmentAccountBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(inflater,container,false)
        val view = binding!!.root


        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  val pref = PreferenceManager.getDefaultSharedPreferences(requireActivity() );
        val pref = requireActivity().getSharedPreferences("fileName", Context.MODE_PRIVATE)
        binding!!.profileName.text= pref.getString("name","not specified ")

        binding!!.cardView.setOnClickListener {
            // as per defined in your FragmentContainerView

            it.findNavController().navigate(R.id.action_navigation_account_to_personalinfoFragment)

        }
        binding!!.cardView2.setOnClickListener {
            // as per defined in your FragmentContainerView

            it.findNavController().navigate(R.id.action_navigation_account_to_favoriteFragment)

        }

    }

}