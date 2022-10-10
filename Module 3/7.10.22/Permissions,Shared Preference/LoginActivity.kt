package com.example.permission

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn:Button
    lateinit var sharedPreferences:SharedPreferences

    @SuppressLint("ApplySharedPref")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edt1=findViewById(R.id.edt1)
        edt2=findViewById(R.id.edt2)
        btn=findViewById(R.id.btn)
        sharedPreferences=getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("NAME","")!!.isEmpty())
        {
            startActivity(Intent(this,DashboardActivity::class.java))
            finish()
        }
        btn.setOnClickListener {
            var name=edt1.text.toString()
            var pass=edt2.text.toString()

            if(name.length==0 && pass.length==0)
            {
                edt1.setError("Please Enter your Name")
                edt2.setError("Please Enter your Password")
            }
            else if (name.length==0)
            {
                edt1.setError("Please Enter your Mobile Number")
            }
            else if(pass.length==0)
            {
                edt2.setError("Please Enter your Password")
            }
            else if(pass.equals("1234"))
            {
                var i=Intent(this,DashboardActivity::class.java)
                sharedPreferences.edit().putString("NAME",name).commit()
                sharedPreferences.edit().putBoolean("USER_SESSION",true).commit()
                startActivity(i)
                finish()
            }
            else
            {
                Toast.makeText(applicationContext,"Wrong credentials",Toast.LENGTH_LONG).show()
            }

        }
    }
}