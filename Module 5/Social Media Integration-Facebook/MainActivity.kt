package com.example.socialmediaintegrationfacebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.facebook.appevents.AppEventsLogger


class MainActivity : AppCompatActivity()
{
    var loginbutton: LoginButton?=null
    var callbackManager: CallbackManager?=null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        FacebookSdk.sdkInitialize(applicationContext)
        setContentView(R.layout.activity_main)
        loginbutton=findViewById(R.id.login_button)
        callbackManager=CallbackManager.Factory.create()

        loginbutton!!.registerCallback(callbackManager,object : FacebookCallback<LoginResult>
        {
            override fun onCancel() {

            }

            override fun onError(error: FacebookException) {
                Toast.makeText(applicationContext,"error"+error, Toast.LENGTH_LONG).show()
                Log.d("TopsTech",error.toString())
            }

            override fun onSuccess(result: LoginResult) {
                Toast.makeText(applicationContext,"Success", Toast.LENGTH_LONG).show()
            }

        })

    }
}