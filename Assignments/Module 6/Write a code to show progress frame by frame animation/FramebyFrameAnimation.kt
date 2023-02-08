package com.example.animations

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class FramebyFrameAnimation : AppCompatActivity()
{
    lateinit var animationDrawable: AnimationDrawable
    lateinit var image:ImageView
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frameby_frame_animation)

        btn=findViewById(R.id.btnstart)
        image=findViewById(R.id.imageView)

        animationDrawable= image.background as AnimationDrawable
        btn.setOnClickListener {
            if (animationDrawable.isRunning)
            {
                animationDrawable.stop()
            }
            else
            {
                animationDrawable.start()
            }
        }
    }
}