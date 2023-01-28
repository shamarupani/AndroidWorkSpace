package com.example.taskmanagementappnew

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity()
{
    var db:DatabaseClass?=null
    override fun onCreate(savedInstanceState: Bundle?)

    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        db= Room.databaseBuilder(applicationContext,DatabaseClass::class.java,"todo").build()
        GlobalScope.launch{
            DataObject.listdata= db!!.dao().getTasks() as MutableList<EntityClass>
        }

        Handler().postDelayed(Runnable {

            var i=Intent(this,MainActivity::class.java)
            startActivity(i)

        },2000)

    }
}