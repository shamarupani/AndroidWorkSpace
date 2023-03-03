package com.example.e_greetings.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.e_greetings.Client.ApiClient
import com.example.e_greetings.Interface.ApiInterface
import com.example.e_greetings.Model.RegisterModel
import com.example.e_greetings.R
import com.example.e_greetings.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding
    lateinit var apiInterface: ApiInterface
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

       sharedPreferences=getSharedPreferences("user_session",Context.MODE_PRIVATE)

       if (sharedPreferences.getBoolean("user_session",false) && !sharedPreferences.getString("mob","")!!.isEmpty())
        {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }
        binding.btnNewUser.setOnClickListener {
            startActivity(Intent(applicationContext,SignupActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            var phone=binding.phone.text.toString()
            var password=binding.password.text.toString()

            apiInterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)
            var call:Call<RegisterModel> =apiInterface.logindata(phone,password)

            call.enqueue(object :Callback<RegisterModel>
            {
                override fun onResponse(call: Call<RegisterModel>,response: Response<RegisterModel>)
                {
                    sharedPreferences.edit().putString("mob",phone).commit()
                    sharedPreferences.edit().putBoolean("user_session",true).commit()
                    Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext, DashboardActivity::class.java))

                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"Fail", Toast.LENGTH_LONG).show()

                }

            })
        }
    }

    override fun onBackPressed() {
        finishAffinity()
        super.onBackPressed()
    }
}