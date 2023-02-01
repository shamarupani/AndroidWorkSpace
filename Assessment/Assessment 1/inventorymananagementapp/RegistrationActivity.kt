package com.example.inventorymananagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.inventorymananagementapp.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityRegistrationBinding
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper= DbHelper(applicationContext)

        binding.btnsignup.setOnClickListener {
            var fname = binding.firstname.text.toString()
            var lname = binding.lastname.text.toString()
            var uname = binding.username.text.toString()
            var email = binding.email.text.toString()
            var phone = binding.phone.text.toString()
            var password = binding.password.text.toString()
            var cpass = binding.confirmpassword.text.toString()


            if (password.length == 0 || cpass.length == 0) {
                Toast.makeText(
                    applicationContext,
                    "Please Enter Proper Password",
                    Toast.LENGTH_LONG
                ).show()
            }

            if (password.equals(cpass)) {
                if (fname.length == 0) {
                    binding.firstname.setError("Please enter proper firstname")
                } else if (lname.length == 0) {
                    binding.lastname.setError("Please Enter Proper LastName")
                } else if (uname.length == 0) {
                    binding.username.setError("Please Enter Proper Username")
                } else if (email.length == 0) {
                    binding.email.setError("Please Enter Proper Email")
                } else if (phone.length != 10) {
                    binding.phone.setError("Please Enter Proper Phone Number")
                } else
                {
                    var m=Model()
                    m.fname=fname
                    m.lname=lname
                    m.uname=uname
                    m.email=email
                    m.phone=phone
                    m.pwd=password

                    var id=dbHelper.insertdata(m)

                    if (id>0)
                    {
                        Toast.makeText(applicationContext,"Record inserted"+id,Toast.LENGTH_LONG).show()
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    else
                    {
                        Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                    }
                }
            }
            else
            {
                Toast.makeText(applicationContext,"Password and confirm password are not same",Toast.LENGTH_LONG).show()
            }
        }
        binding.alreadyhaveaccount.setOnClickListener{
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }
}