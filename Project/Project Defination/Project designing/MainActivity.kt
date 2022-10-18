package com.example.registrationlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity()
{
lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn=findViewById(R.id.btn)

        btn.setOnClickListener {

            var i=Intent(this,LoginActivity::class.java)
            startActivity(i)
         }
    }

    override fun onBackPressed()
    {
        finishAffinity()
        super.onBackPressed()
    }
}