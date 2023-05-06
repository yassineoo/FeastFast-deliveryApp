package com.example.feastfast.ui.menuItemDetails

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentMenuItemDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuItemDetailsFragment : BottomSheetDialogFragment() {

    lateinit var binding : FragmentMenuItemDetailsBinding
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
        val behaviour = BottomSheetBehavior.from(binding.layoutRoot)
        binding.buttonLeave.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_menuItemDetailsFragment_to_navigation_explore)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        disableBottomSheetDraggableBehavior()
    }

    private fun disableBottomSheetDraggableBehavior() {
        this.isCancelable = false
        this.dialog?.setCanceledOnTouchOutside(false)
    }
}