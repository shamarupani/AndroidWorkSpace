package com.example.registrationlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button=findViewById(R.id.login)

        button.setOnClickListener {
            var i=Intent(this,LogoutActivity::class.java)
            startActivity(i)
        }
    }
}