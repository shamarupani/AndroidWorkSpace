package com.example.module4assignments

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    lateinit var edt1: EditText
    lateinit var edt2: EditText
    lateinit var btn1: Button
    lateinit var text: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        text = findViewById(R.id.text)
        btn1.setOnClickListener {
            val builder = StringBuilder()
            var first = edt1.text.toString()
            var second = edt2.text.toString()
            var a = Integer.parseInt(first)
            var b = Integer.parseInt(second)
            for (rolls in a until b ) {

               var value =rolls+1
                //Test if numbers generated are correct
                // Create the text view
                val textView = TextView(this)
                textView.textSize = 40f
                builder.append(value)
                textView.text = builder.toString()

                // Set the text view as the activity layout
                setContentView(textView)
                //store generated numbers here
                System.out.println(value)
            }



            }
        }
    }
