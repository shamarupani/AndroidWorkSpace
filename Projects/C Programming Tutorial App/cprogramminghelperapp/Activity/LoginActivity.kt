package com.example.cprogramminghelperapp.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cprogramminghelperapp.Client.ApiClient
import com.example.cprogramminghelperapp.Interface.ApiInterface
import com.example.cprogramminghelperapp.Model.Register_Model
import com.example.cprogramminghelperapp.databinding.ActivityLoginBinding
import com.example.cprogramminghelperapp.ui.home.Home
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

        if (sharedPreferences.getBoolean("user_session",false) && !sharedPreferences.getString("uname","")!!.isEmpty())
        {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }

        binding.btnNewUser.setOnClickListener {
            startActivity(Intent(applicationContext,RegistrationActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            var uname=binding.username.text.toString()
            var password=binding.password.text.toString()

            apiInterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)
            var logincall:Call<Register_Model> = apiInterface.logindetail(uname,password)

            logincall.enqueue(object :Callback<Register_Model>
            {
                override fun onResponse(call: Call<Register_Model>, response: Response<Register_Model>)
                {
                    sharedPreferences.edit().putString("uname",uname).commit()
                    sharedPreferences.edit().putBoolean("user_session",true).commit()
                    Toast.makeText(applicationContext,"success",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,DashboardActivity::class.java))


                }

                override fun onFailure(call: Call<Register_Model>, t: Throwable)
                {
                   Toast.makeText(applicationContext,"fail",Toast.LENGTH_LONG).show()
                }
            })
        }

    }
}