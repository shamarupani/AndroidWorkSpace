package com.example.module7assignments

import android.annotation.SuppressLint
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

class WifiActivity : AppCompatActivity()
{
    lateinit var btn1: Button
    lateinit var text1:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi)

        btn1 = findViewById(R.id.btn1)
        text1=findViewById(R.id.text1)

        val wifi=applicationContext.getSystemService(WIFI_SERVICE) as WifiManager

        btn1.setOnClickListener {
           wifi.isWifiEnabled = !wifi.isWifiEnabled

            if (!wifi.isWifiEnabled)
            {

                text1.text="Wifi is ON"
            }
            else
            {
                text1.text="Wifi is OFF"
            }
        }

    }
}