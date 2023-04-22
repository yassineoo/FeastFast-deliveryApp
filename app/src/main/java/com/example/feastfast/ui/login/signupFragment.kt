package com.example.feastfast.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentLoginBinding
import com.example.feastfast.databinding.FragmentSignupBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [signupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class signupFragment : Fragment() {
    var binding : FragmentSignupBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater,container,false)
        val view = binding!!.root


        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.signupLink?.setOnClickListener{
            it.findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }



    }
}