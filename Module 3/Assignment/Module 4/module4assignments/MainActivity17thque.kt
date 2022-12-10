package com.example.module4assignments

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity17thque : AppCompatActivity()
{
    lateinit var toolbar: Toolbar
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_17thque)
        toolbar=findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        toolbar.setLogo(R.mipmap.ic_launcher)
        toolbar.setNavigationIcon(R.drawable.ic_baseline_navigate_before_24)
        toolbar.setSubtitle("Last Seen")
        toolbar.setBackgroundColor(Color.GRAY)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(applicationContext,"Back button presseed", Toast.LENGTH_LONG).show()
        }
    }
}