package com.example.module4assignments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity9thque : AppCompatActivity()
{
    lateinit var text:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_9thque)

        text = findViewById(R.id.text)
        text.setOnClickListener {
            var url = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"
            var j=Intent(Intent.ACTION_VIEW)
            j.setData(Uri.parse(url))
            startActivity(j)
        }
    }


}