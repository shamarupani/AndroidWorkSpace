package com.example.module4assignments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity7thque : AppCompatActivity()
{
    lateinit var txt1:TextView
    lateinit var btn1:Button
    var i=0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_7thque)

        txt1=findViewById(R.id.txt1)
        btn1=findViewById(R.id.btn1)

        btn1.setOnClickListener {
            onClick()

        }
    }

    private fun onClick()
    {
        if(i%2==0){
            txt1.setVisibility(View.INVISIBLE)
        }
        else{
            txt1.setVisibility(View.VISIBLE)
        }
        i++
    }
}