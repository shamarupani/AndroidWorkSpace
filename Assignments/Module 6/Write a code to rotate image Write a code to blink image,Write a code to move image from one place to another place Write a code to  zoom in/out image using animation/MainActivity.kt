package com.example.animations


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity()
{  lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var image:ImageView
    lateinit var btnzoomin:Button
    lateinit var btnzoomout:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        image=findViewById(R.id.image)
        btnzoomin=findViewById(R.id.zoomInButton)
        btnzoomout=findViewById(R.id.zoomOutButton)

        btn1.setOnClickListener {
            animatedata()
        }
        btn2.setOnClickListener {
            animatedata2()
        }
        btnzoomout.setOnClickListener {
            animatedata4()
        }
        btnzoomin.setOnClickListener {
            animatedata3()
        }
    }

    private fun animatedata4() {
        var anim = AnimationUtils.loadAnimation(applicationContext,R.anim.zoom_out)
        image.startAnimation(anim)      }

    private fun animatedata3() {
        var anim = AnimationUtils.loadAnimation(applicationContext,R.anim.zoom_in)
        image.startAnimation(anim)    }

    private fun animatedata2() {
        var anim = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate)
        btn2.startAnimation(anim)    }

    private fun animatedata() {
        var anim = AnimationUtils.loadAnimation(applicationContext,R.anim.blink)
        btn1.startAnimation(anim)

    }
}
