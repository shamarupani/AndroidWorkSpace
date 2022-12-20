package com.example.listandsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.core.view.contains

class MainActivity : AppCompatActivity() {
    lateinit var list2:ListView
    lateinit var list: MutableList<String>
    lateinit var search:SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search=findViewById(R.id.search)
        list2=findViewById(R.id.list1)
        list=ArrayList()
        list.add("Android")
        list.add("Kotlin")
        list.add("Java")
        list.add("Php")

        var adapter1=ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        list2.adapter=adapter1


        search.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               /* if (list.contains(query))
                {
                    adapter1.filter.filter(query)
                }*/
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter1.filter.filter(newText)
                return false
            }

        })
    }
}