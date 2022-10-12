package com.example.milkonmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button

class SplashScreenActivity : AppCompatActivity()
{
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        btn=findViewById(R.id.btn)
        animatedata()
        btn.setOnClickListener {
            var i=Intent(this,DashboardActivity::class.java)
            startActivity(i)
        }


    }

    private fun animatedata() {
        var animation:Animation=AnimationUtils.loadAnimation(applicationContext,R.anim.blink)
        btn.startAnimation(animation)
    }
}