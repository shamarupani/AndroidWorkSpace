package com.example.roomdb.Activity



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import androidx.room.Room
import com.example.roomdb.Database.DatabaseClass
import com.example.roomdb.Entity.User
import com.example.roomdb.R
import com.example.roomdb.UserAdapter

import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity()
{
    lateinit var fab:FloatingActionButton
    lateinit var recyclerView:RecyclerView
    lateinit var list: MutableList<User>
    var db:DatabaseClass? = null
    var mAdapter: UserAdapter? =  null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab=findViewById(R.id.fab)
        recyclerView=findViewById(R.id.recyclerview)
        list=ArrayList()

        var l1:RecyclerView.LayoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=l1
        db = Room.databaseBuilder(
            applicationContext, DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()

        getalldata()

        fab.setOnClickListener {
            var i=Intent(this,AddUserActivity::class.java)
            startActivity(i)
        }
    }

    private fun getalldata()
    {
         list= db!!.daoClass().getUsers()

        if (list.size>0)
        {
            mAdapter= UserAdapter(list)
            recyclerView.adapter=mAdapter

        }
        else
        {
            Toast.makeText(this,"no data",Toast.LENGTH_LONG).show()
        }
    }
}
