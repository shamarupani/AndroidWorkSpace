package com.example.e_greetings.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.e_greetings.Client.ApiClient
import com.example.e_greetings.Interface.ApiInterface
import com.example.e_greetings.R
import com.example.e_greetings.databinding.ActivityLoginBinding
import com.example.e_greetings.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySignupBinding
    lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnsignup.setOnClickListener {
            var fname=binding.firstname.text.toString()
            var lname=binding.lastname.text.toString()
            var email=binding.email.text.toString()
            var phone=binding.phone.text.toString()
            var city=binding.city.text.toString()
            var password=binding.password.text.toString()
            var cpass=binding.confirmpassword.text.toString()

            if (password.length==0 || cpass.length==0)
            {
                Toast.makeText(applicationContext,"Please Enter Proper Password",Toast.LENGTH_LONG).show()
            }

            if (password.equals(cpass))
            {
                if (fname.length==0)
                {
                    binding.firstname.setError("Please enter proper firstname")
                }
                else if(lname.length==0 )
                {
                    binding.lastname.setError("Please Enter Proper LastName")
                }
                else if(email.length==0 )
                {
                    binding.email.setError("Please Enter Proper Email")
                }
                else if(phone.length!=10 )
                {
                    binding.phone.setError("Please Enter Proper Phone Number")
                }
                else
                {
                    apiInterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)
                    var registercall:Call<Void> =apiInterface.registerdetail(fname,lname,email,phone,city,password)

                    registercall.enqueue(object :Callback<Void>
                    {
                        override fun onResponse(call: Call<Void>, response: Response<Void>)
                        {
                            startActivity(Intent(applicationContext,LoginActivity::class.java))
                        }

                        override fun onFailure(call: Call<Void>, t: Throwable)
                        {
                            Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                        }

                    })
                }
            }
            else
            {
                Toast.makeText(applicationContext,"Password and confirm password are not same",Toast.LENGTH_LONG).show()
            }
        }
       binding.alreadyhaveaccount.setOnClickListener{
            startActivity(Intent(applicationContext, LoginActivity::class.java))

        }

    }
}