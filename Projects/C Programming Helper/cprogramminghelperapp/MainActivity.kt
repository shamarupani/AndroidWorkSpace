package com.example.cprogramminghelperapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity()
{
    lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image=findViewById(R.id.image)
        var animation: Animation = AnimationUtils.loadAnimation(applicationContext,R.anim.blink)
        image.startAnimation(animation)

        Handler().postDelayed(Runnable {
            animation.cancel()
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}
