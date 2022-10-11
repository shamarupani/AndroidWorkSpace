package com.example.milkonmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.google.android.material.slider.Slider
import java.util.ArrayList

class DashboardActivity : AppCompatActivity() {

    lateinit var slider:SliderLayout
    lateinit var recycler:RecyclerView
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        slider=findViewById(R.id.slider)


        var map=HashMap<String,Int>()
        map.put("A", R.drawable.a)
        map.put("B",R.drawable.b)
        map.put("C",R.drawable.c)
        map.put("D",R.drawable.d)
        map.put("E",R.drawable.e)
        map.put("F",R.drawable.f)
        map.put("G",R.drawable.g)
        map.put("H",R.drawable.h)


        for (name in map.keys)
        {
            var textslider=TextSliderView(this)
            textslider.image(map.get(name)!!)
            slider.addSlider(textslider)
        }

        recycler=findViewById(R.id.recycler)
        list=ArrayList()


        var layout:RecyclerView.LayoutManager=GridLayoutManager(this,2)
        recycler.layoutManager=layout

        list.add(Model("SUPER GOLD 500 ml",R.drawable.milk,"Rs. 33.0","Subscribe @ ₹33.0","ADD"))
        list.add(Model("SUPER GOLD 500 ml",R.drawable.ghee,"Rs. 33.0","Subscribe @ ₹33.0","ADD"))
        list.add(Model("SUPER GOLD 500 ml",R.drawable.milk,"Rs. 33.0","Subscribe @ ₹33.0","ADD"))
        list.add(Model("SUPER GOLD 500 ml",R.drawable.ghee,"Rs. 33.0","Subscribe @ ₹33.0","ADD"))

        var adapter=MyAdapter(applicationContext,list)
        recycler.adapter=adapter
    }
}