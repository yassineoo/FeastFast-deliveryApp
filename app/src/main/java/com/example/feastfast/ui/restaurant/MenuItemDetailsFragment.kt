package com.example.feastfast.ui.restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentMenuItemDetailsBinding
import com.example.feastfast.models.room.AppDatabase
import com.example.feastfast.models.CartItem
import com.example.feastfast.models.MenuItem
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuItemDetailsFragment() : BottomSheetDialogFragment() {

    lateinit var binding : FragmentMenuItemDetailsBinding
    lateinit var myContext : FragmentActivity
    lateinit var radioGroup : RadioGroup
    lateinit var cartItem : CartItem
    lateinit var addToCartButton : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuItemDetailsBinding.inflate(inflater,container,false)
        val view = binding.root
        val behaviour = BottomSheetBehavior.from(binding.layoutRoot)
        behaviour.isHideable = false
        behaviour.isDraggable=false
        behaviour.state = BottomSheetBehavior.STATE_EXPANDED
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuItem = arguments?.getSerializable("item") as MenuItem
        cartItem = menuItem.menuItemToCartItem(menuItem)
        myContext = requireActivity()


        //dish quantity logic start
        radioGroup= binding.radioGroup
        val increment = binding.buttonPlus
        val decrement = binding.buttonMinus
        val textAmmount = binding.textAmmount
        addToCartButton = binding.buttonAddToCart
        increment.setOnClickListener {
            cartItem.quantity = cartItem.quantity!! + 1
            textAmmount.text=cartItem.quantity.toString()
            addToCartButton.setText("Add to cart- DZD"+cartItem.getTotalPrice().toString())
        }
        decrement.setOnClickListener {
            cartItem.quantity = cartItem.quantity!! - 1
            textAmmount.text=cartItem.quantity.toString()
            addToCartButton.setText("Add to cart- DZD"+cartItem.getTotalPrice().toString())
        }
        //dish quantity logic end

        radioGroup.setOnCheckedChangeListener(object: RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                val checked = when (checkedId) {
                    R.id.radio_L -> "L"
                    R.id.radio_XL -> "XL"
                    R.id.radio_XXL -> "XXL"
                    else -> "L"
                }
                cartItem.size=checked
                addToCartButton.setText("Add to cart- DZD"+cartItem.getTotalPrice().toString())

            }
        })

        binding.buttonLeave.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_menuItemDetailsFragment_to_restaurantFragment)
        }
        binding.buttonAddToCart.setOnClickListener {
            AppDatabase.getInstance(myContext)!!.getMenuItemDao().addToCart((cartItem))
            Toast.makeText(myContext,"Items added to cart!" , Toast.LENGTH_SHORT).show()
            NavHostFragment.findNavController(this).navigate(R.id.action_menuItemDetailsFragment_to_restaurantFragment)
        }
    }

    public fun onRadioButtonClicked(view: View){
        if (view is RadioButton){
            if (view.isChecked){
                val id = view.id
                val checkedButton = myContext.findViewById<RadioButton>(id)
                cartItem.size=checkedButton.text.toString()
                addToCartButton.setText("Add to cart- DZD"+cartItem.getTotalPrice().toString())
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        disableBottomSheetDraggableBehavior()
    }

    private fun disableBottomSheetDraggableBehavior() {
        this.isCancelable = false
        this.dialog?.setCanceledOnTouchOutside(true)
    }
}