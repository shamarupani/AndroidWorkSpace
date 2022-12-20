package com.example.cprogramminghelperapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegistrationActivity : AppCompatActivity()
{
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        btn=findViewById(R.id.btn)

        btn.setOnClickListener {

            var i= Intent(this,LoginActivity::class.java)
            startActivity(i)
        }
    }

    override fun onBackPressed()
    {
        finishAffinity()
        super.onBackPressed()
    }
    }
