package com.example.module4assignments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity14thque : AppCompatActivity()
{
    lateinit var list:ListView
    lateinit var title: Array<String>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_14thque)

        list=findViewById(R.id.list)

        title = resources.getStringArray(R.array.titles)
        var adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,title)
        list.adapter=adapter
    }
}
