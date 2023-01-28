package com.example.taskmanagementappnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.AdapterContextMenuInfo
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.taskmanagementappnew.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    var db: DatabaseClass? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        db = Room.databaseBuilder(applicationContext, DatabaseClass::class.java, "todo").build()


        binding.add.setOnClickListener {
            var i = Intent(this, CreateCard::class.java)
            setRecycler()
            startActivity(i)

        }
        binding.deleteAll.setOnClickListener {
            DataObject.deleteAll()
            GlobalScope.launch {
                db!!.dao().deleteAll()
            }
            setRecycler()
        }
/*
        binding.sortby.setOnClickListener {

           // Toast.makeText(applicationContext,"Clicked",Toast.LENGTH_LONG).show()

            DataObject.sorttask(date = String())
            setRecycler()
        }*/
        setRecycler()
    }

    private fun setRecycler()
    {
        binding.recyclerView.adapter = Adapter(DataObject.getalldata())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.sortmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {

        when (item.itemId) {
            R.id.sortdate -> {
                //        DataObject.sorttask(date = String())
                setRecycler()
            }
            R.id.sorttime -> {
                //        DataObject.sorttime(time = String())
                setRecycler()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}