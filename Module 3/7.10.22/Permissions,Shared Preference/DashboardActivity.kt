package com.example.permission

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {
    lateinit var txt:TextView
    lateinit var button:Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        txt=findViewById(R.id.txt1)
        button=findViewById(R.id.button)
        sharedPreferences=getSharedPreferences("USER_SESSION",Context.MODE_PRIVATE)

        txt.setText("Welcome "+sharedPreferences.getString("NAME","De"))

        button.setOnClickListener {
            sharedPreferences.edit().clear().commit()
            var i=Intent(this,LoginActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}