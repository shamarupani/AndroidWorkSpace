package com.example.module4assignments

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity10thque : AppCompatActivity() {
    lateinit var txt1: TextView
    lateinit var decbtn: Button
    lateinit var incbutton: Button
    var counter=0F
    private var size:Float=0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_10thque)

        txt1 = findViewById(R.id.count)
        decbtn = findViewById(R.id.decrement_btn)
        incbutton = findViewById(R.id.increment_btn)

        counter=pixeltosp(txt1.textSize)

        incbutton.setOnClickListener {
            changetext(true)
      }
        decbtn.setOnClickListener {
            changetext(false)
        }
    }

    private fun changetext(b: Boolean)
    {

        size = if(b) ++counter else --counter
        txt1.textSize=size
    }

    private fun pixeltosp(px: Float): Float
    {
        var scaleddensity=resources.displayMetrics.scaledDensity
        return px/scaleddensity
    }
}



