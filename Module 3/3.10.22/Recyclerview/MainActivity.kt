package com.example.recyclerview

import Model
import MyAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       recyclerView= findViewById(R.id.recycler)
        list=ArrayList()

        var layout:RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=layout

        list.add(Model(R.drawable.android,"Android"))
        list.add(Model(R.drawable.java,"Java"))
        list.add(Model(R.drawable.ios,"Ios"))
        list.add(Model(R.drawable.php,"Php"))

        var adapter=MyAdapter(applicationContext,list)
        recyclerView.adapter=adapter

    }
}