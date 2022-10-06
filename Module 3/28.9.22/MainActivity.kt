package com.example.shamaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView


class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var slider:SliderLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar=findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        slider=findViewById(R.id.slider)

        toolbar.setLogo(R.mipmap.ic_launcher)

        toolbar.setSubtitle("Last Seen")
        toolbar.setNavigationIcon(R.drawable.ic_baseline_navigate_before_24)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(applicationContext,"Back button presseed",Toast.LENGTH_LONG).show()
        }
        var map=HashMap<String,Int>()
        map.put("A",R.drawable.small)
        map.put("B",R.drawable.logo)
        map.put("C",R.drawable.a)
        map.put("D",R.drawable.image)

        for (name in map.keys)
        {
            var textslider=TextSliderView(this)
            textslider.description(name)
                      .image(map.get(name)!!)
            slider.addSlider(textslider)
        }
    }
}