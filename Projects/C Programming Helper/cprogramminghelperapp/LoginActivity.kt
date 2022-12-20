package com.example.cprogramminghelperapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button=findViewById(R.id.login)

        button.setOnClickListener {
            var i= Intent(this,MainActivity2::class.java)
            startActivity(i)
        }
    }
}