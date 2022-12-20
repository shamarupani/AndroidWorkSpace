package com.example.module4assignments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module4assignments.databinding.ActivityMain3rdqueBinding
import com.example.module4assignments.databinding.ActivityMain4thqueBinding

class MainActivity4thque : AppCompatActivity()
{
    private lateinit var binding: ActivityMain4thqueBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4thqueBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.login.setOnClickListener {
            var f=Login1Fragment()
            var fm=supportFragmentManager
            var ft=fm.beginTransaction()
            ft.replace(R.id.f1,f).commit()
        }
        binding.registration.setOnClickListener {
            var f2=RegistrationFragment()
            var fm2=supportFragmentManager
            var ft2=fm2.beginTransaction()
            ft2.replace(R.id.f2,f2).commit()
        }
    }
}