package com.example.feastfast.ui.orders

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feastfast.databinding.FragmentOrdersBinding
import com.example.feastfast.models.Order

class OrdersFragment : Fragment() {
    lateinit var binding : FragmentOrdersBinding
    lateinit var myContext : Context
    lateinit var adapter: OrdersAdapter
    lateinit var data : List<Order>
    lateinit var myActivity : AppCompatActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrdersBinding.inflate(inflater,container,false)
        val view = binding.root


        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myContext= requireActivity()
        myActivity = activity as AppCompatActivity
        binding.recycleView.layoutManager = LinearLayoutManager(myContext)
        data = loadData()
        binding.recycleView.adapter = OrdersAdapter(data,myContext,myActivity)
    }


    fun loadData() : List<Order>{
        return listOf(
            Order(1,1,"Pizzeria","In preparation","23/06/2023","01:39 PM","Esi, Oued Smar",1500.3F,false),
            Order(1,1,"Pizzeria","In preparation","23/06/2023","01:39 PM","Esi, Oued Smar",1500.3F,true),
            Order(1,1,"Pizzeria","In preparation","23/06/2023","01:39 PM","Esi, Oued Smar",1500.3F,false),
            Order(1,1,"Pizzeria","Completed","23/06/2023","01:39 PM","Esi, Oued Smar",1500.3F,false),
            Order(1,1,"Pizzeria","In preparation","23/06/2023","01:39 PM","Esi, Oued Smar",1500.3F,false),
            Order(1,1,"Pizzeria","In preparation","23/06/2023","01:39 PM","Esi, Oued Smar",1500.3F,false),
        )

    }
}