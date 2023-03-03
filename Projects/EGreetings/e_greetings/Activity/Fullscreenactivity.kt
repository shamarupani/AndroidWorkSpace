package com.example.e_greetings.Activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_greetings.R
import com.example.e_greetings.databinding.ActivityCategoryBinding
import com.example.e_greetings.databinding.ActivityFullscreenactivityBinding
import com.squareup.picasso.Picasso

class Fullscreenactivity : AppCompatActivity()
{
    private lateinit var binding: ActivityFullscreenactivityBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityFullscreenactivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i=intent
        var url = i.getStringExtra("f_pos")

        Picasso.get().load(url).into(binding.photoview)
    }
}