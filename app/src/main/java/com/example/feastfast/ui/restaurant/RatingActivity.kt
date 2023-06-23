package com.example.feastfast.ui.restaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.feastfast.R
import com.example.feastfast.databinding.ActivityRatingBinding


class RatingActivity : AppCompatActivity() {
    lateinit var binding: ActivityRatingBinding
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRatingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}