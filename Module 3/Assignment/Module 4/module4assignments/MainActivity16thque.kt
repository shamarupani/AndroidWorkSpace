package com.example.module4assignments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity16thque : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    lateinit var img1: ImageView
    lateinit var txt1:TextView
    lateinit var txt2: TextView
    lateinit var txt3:TextView
    lateinit var seek1: SeekBar
    lateinit var seek2:SeekBar
    lateinit var seek3:SeekBar
    lateinit var linear:LinearLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity16thque)

        img1=findViewById(R.id.img1)
        seek1=findViewById(R.id.seek1)
        seek2=findViewById(R.id.seek2)
        seek3=findViewById(R.id.seek3)
        txt1=findViewById(R.id.txt1)
        txt2=findViewById(R.id.txt2)
        txt3=findViewById(R.id.txt3)
        linear=findViewById(R.id.linear)
        seek1.setOnSeekBarChangeListener(this)
        seek2.setOnSeekBarChangeListener(this)
        seek3.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean)
    {
        updateBackground()

    }

    override fun onStartTrackingTouch(p0: SeekBar?)
    {

    }

    override fun onStopTrackingTouch(p0: SeekBar?)
    {

    }

    private fun updateBackground()
    {
          var  seek1 = seek1.progress
          var  seek2 = seek2.progress
          var  seek3 = seek3.progress
        linear.setBackgroundColor(Color.rgb(seek1,seek2,seek3))
        //linear.setBackgroundColor(-0x1000000 + seek1 * 0x10000 + seek2 * 0x100 + seek3)
    }
}