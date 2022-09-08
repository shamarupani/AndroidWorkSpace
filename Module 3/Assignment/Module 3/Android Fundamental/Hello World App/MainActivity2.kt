package com.example.helloworld

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout


class MainActivity2 : AppCompatActivity() {
    lateinit var rel:RelativeLayout
    lateinit var btn1:Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn1=findViewById(R.id.btn1)
        rel=findViewById(R.id.      rel)


        btn1.setOnClickListener {
            rel.setBackgroundColor(Color.CYAN)
        }
    }
    override fun onBackPressed() {
        finishAffinity()
    }
}