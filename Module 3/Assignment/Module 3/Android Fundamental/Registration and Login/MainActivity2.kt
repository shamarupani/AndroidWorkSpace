package com.example.datapassing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.datapassing.databinding.ActivityMain2Binding
import com.example.datapassing.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {
            var n= binding.edt1.text.toString()
            var p=binding.edt2.text.toString()

            if(n.length==0 && p.length==0)
            {
                binding.edt1.setError("Please Enter your Email Id")
                binding.edt2.setError("Please Enter your Password")
            }
            else if (n.length==0)
            {
                binding.edt1.setError("Please Enter your Email Id")
            }
            else if(p.length==0)
            {
                binding.edt2.setError("Please Enter your Password")
            }
            else
            {
                if(n.equals("shama.rupani@gmail.com")&& p.equals("abc@123"))
                {
                    Toast.makeText(applicationContext,"Login Success",Toast.LENGTH_LONG).show()
                    var i=Intent(this,MainActivity3 ::class.java)
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