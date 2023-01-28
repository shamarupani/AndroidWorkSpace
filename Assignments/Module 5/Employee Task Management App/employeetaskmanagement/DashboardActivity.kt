package com.example.employeetaskmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.employeetaskmanagement.databinding.ActivityDashboardBinding
import com.example.employeetaskmanagement.databinding.ActivityLoginBinding

class DashboardActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.projectView.setOnClickListener {
            var i = Intent(this,ProjectActivity::class.java)
            startActivity(i)
        }

        binding.profileView.setOnClickListener {
            var i = Intent(this,ProfileActivity::class.java)
            startActivity(i)
        }
    }
}