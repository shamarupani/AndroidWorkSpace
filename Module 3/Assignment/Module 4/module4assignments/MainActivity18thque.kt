package com.example.module4assignments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuItemCompat


class MainActivity18thque : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_18thque)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
       var menu1= getMenuInflater().inflate(R.menu.spinner, menu)
        val item: MenuItem = menu!!.findItem(R.id.spinner1)
        val spinner = MenuItemCompat.getActionView(item) as Spinner
        val adapter = ArrayAdapter.createFromResource(this,R.array.spinner_list_item_array, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        return true
    }
}


