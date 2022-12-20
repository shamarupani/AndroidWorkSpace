package com.example.shoppingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginPageActivity : AppCompatActivity() {

    lateinit var button:Button
    lateinit var edt1:EditText
    lateinit var edt2:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        button=findViewById(R.id.btn1)
        edt1=findViewById(R.id.edt1)
        edt2=findViewById(R.id.edt2)

        button.setOnClickListener {
            var n= edt1.text.toString()
            var p=edt2.text.toString()

            if(n.length==0 && p.length==0)
            {
                edt1.setError("Please Enter your Mobile Number")
                edt2.setError("Please Enter your Password")
            }
            else if (n.length==0)
            {
                edt1.setError("Please Enter your Mobile Number")
            }
            else if(p.length==0)
            {
                edt2.setError("Please Enter your Password")
            }
            else
            {
                    if(n.equals("989898")&& p.equals("1234"))
                    {
                        Toast.makeText(applicationContext,"Login Success",Toast.LENGTH_LONG).show()
                        var i=Intent(this,MainActivity::class.java)
                        startActivity(i)
                    }
                else
                    {
                        Toast.makeText(applicationContext,"Login Failed",Toast.LENGTH_LONG).show()
                    }
            }
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}