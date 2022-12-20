package com.example.module4assignments

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity()
{
    lateinit var txt:TextView
    lateinit var txt1:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        txt=findViewById(R.id.text)
      //  txt1=findViewById(R.id.text1)


        val bundle = intent.extras
        if (bundle != null)
        {
            txt.text = "Numbers = ${bundle.getString("array")}"
           // txt.text = "First num = ${bundle.getString("first")}"
            //txt1.text1 = "Second num = ${bundle.getString("second")}"

        }


    }

}