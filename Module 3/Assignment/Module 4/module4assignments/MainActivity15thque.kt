package com.example.module4assignments

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RadioButton

class MainActivity15thque : AppCompatActivity()
{
    lateinit var linear:LinearLayout
    lateinit var rb1:RadioButton
    lateinit var rb2:RadioButton
    lateinit var rb3:RadioButton
    lateinit var rb4:RadioButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_15thque)

        linear=findViewById(R.id.linear)
        rb1=findViewById(R.id.rb1)
        rb2=findViewById(R.id.rb2)
        rb3=findViewById(R.id.rb3)
        rb4=findViewById(R.id.rb4)

        rb1.setOnClickListener {
            linear.setBackgroundColor(Color.RED)
        }
        rb2.setOnClickListener {
            linear.setBackgroundColor(Color.GREEN)
        }
        rb3.setOnClickListener {
            linear.setBackgroundColor(Color.BLUE)
        }
        rb4.setOnClickListener {
            linear.setBackgroundColor(Color.MAGENTA)
        }

    /*    rb1.setOnCheckedChangeListener { compoundButton, b ->

            linear.setBackgroundColor(Color.RED)
        }

        rb2.setOnCheckedChangeListener { compoundButton, b ->

            linear.setBackgroundColor(Color.GREEN)
        }

        rb3.setOnCheckedChangeListener { compoundButton, b ->

            linear.setBackgroundColor(Color.BLUE)
        }

        rb4.setOnCheckedChangeListener { compoundButton, b ->

            linear.setBackgroundColor(Color.BLACK)
        }*/

    }
}