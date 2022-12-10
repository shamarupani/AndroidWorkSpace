package com.example.module4assignments

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var txt2:TextView
    lateinit var result:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1=findViewById(R.id.edt1)
        txt2=findViewById(R.id.txt2)
        result=findViewById(R.id.result)


edt1.setOnClickListener {
    val c: StringBuffer = StringBuffer(edt1.getText().toString())
    result.setText(c.reverse())
}
        }
    }
