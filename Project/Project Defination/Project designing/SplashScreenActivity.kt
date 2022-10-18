package com.example.registrationlogin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class SplashScreenActivity : AppCompatActivity()
{
    lateinit var image:ImageView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        image=findViewById(R.id.image)
        var animation:Animation= AnimationUtils.loadAnimation(applicationContext,R.anim.blink)
        image.startAnimation(animation)

        Handler().postDelayed(Runnable {
            animation.cancel()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}