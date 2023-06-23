package com.example.feastfast.ui.account

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentNotLoginBinding
import com.example.feastfast.databinding.FragmentOrdersBinding
import com.example.feastfast.ui.login.LoginActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotLoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotLoginFragment : Fragment() {




    var binding : FragmentNotLoginBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotLoginBinding.inflate(inflater,container,false)
        val view = binding!!.root


        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.loginRedirect.setOnClickListener {
            val intent = Intent(requireActivity(), LoginActivity::class.java)
            requireActivity().startActivity(intent)
        }


    }

}