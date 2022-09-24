package com.example.datapassing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.datapassing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn.setOnClickListener {
            var a=   binding.edt1.text.toString()
            var b=   binding.edt2.text.toString()
            var c=  binding.edt3.text.toString()
            var d=  binding.edt4.text.toString()
            var e=  binding.edt5.text.toString()
            var f=  binding.edt6.text.toString()

            if (a.length==0 && b.length==0 && c.length==0 && d.length==0 && e.length==0 && f.length==0)
            {

                    binding.edt1.setError("Enter your First Name")
                    binding.edt2.setError("Enter your Last Name")
                    binding.edt3.setError("Enter your Username")
                    binding.edt4.setError("Enter your Email Address")
                    binding.edt5.setError("Enter your Password")
                    binding.edt6.setError("Please Confirm Password")


            }
            else if (a.length==0)
            {
                binding.edt1.setError("Enter your First Name")
            }
            else if (b.length==0)
            {
                binding.edt2.setError("Enter your Last Name")
            }
            else if (c.length==0)
            {
                binding.edt3.setError("Enter your Username")
            }
            else if (d.length==0)
            {
                binding.edt4.setError("Enter your Email Address")
            }
            else if (e.length==0)
            {
                binding.edt5.setError("Enter your Password")
            }
            else if (f.length==0)
            {
                binding.edt6.setError("Please Confirm Password")
            }
            else
            {
                if (a.equals("Shama")&& b.equals("Rupani")&& c.equals("Shama123") && d.equals("shama.rupani@gmail.com") && e.equals("abc@123") && f.equals("abc@123"))
                {
                    Toast.makeText(this,"Registration Success",Toast.LENGTH_LONG).show()
                    var i=Intent(this,MainActivity2::class.java)
                    startActivity(i)
                }
                else
                {
                    Toast.makeText(this,"Registration Failed",Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}