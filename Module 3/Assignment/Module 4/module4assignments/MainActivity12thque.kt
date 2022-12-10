package com.example.module4assignments

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView

class MainActivity12thque : AppCompatActivity()
{
    lateinit var checkBox: CheckBox
    lateinit var txt:TextView
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_12thque)

        checkBox=findViewById(R.id.checkbox)
        txt=findViewById(R.id.txt)

        checkBox.setOnCheckedChangeListener { compoundButton, b ->

           if (checkBox.isChecked)
            {
                txt.setVisibility(View.VISIBLE)
            }
            else
            {
                txt.setVisibility(View.GONE)
            }
        }
    }
}