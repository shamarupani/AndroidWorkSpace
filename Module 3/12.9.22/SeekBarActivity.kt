package com.example.mynewapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView

class SeekBarActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    lateinit var img1:ImageView
    lateinit var txt1:TextView
    lateinit var txt2:TextView
    lateinit var txt3:TextView
    lateinit var seek1:SeekBar
    lateinit var seek2:SeekBar
    lateinit var seek3:SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar)
        img1=findViewById(R.id.img1)
        seek1=findViewById(R.id.seek1)
        seek2=findViewById(R.id.seek2)
        seek3=findViewById(R.id.seek3)
        txt1=findViewById(R.id.txt1)
        txt2=findViewById(R.id.txt2)
        txt3=findViewById(R.id.txt3)


        seek1.setOnSeekBarChangeListener(this)   //press alt+enter on this to get its method
        seek2.setOnSeekBarChangeListener(this)
        seek3.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        var r=seek1.progress
        var g=seek2.progress
        var b=seek3.progress
        img1.setBackgroundColor(Color.rgb(r,g,b))
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}