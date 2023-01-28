package com.example.to_doapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.to_doapp.databinding.ActivityAddNewTaskBinding
import com.example.to_doapp.databinding.ActivityMainBinding

class AddNewTask : AppCompatActivity()
{
    private lateinit var binding: ActivityAddNewTaskBinding
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewTaskBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper= DbHelper(applicationContext)

        binding.btnsave.setOnClickListener {
            val task = binding.taskedit.text.toString()

            var m=Model()
            m.title=task

            var id=dbHelper.insertdata(m)
            if (id>0)
            {
                Toast.makeText(applicationContext,"Data Inserted", Toast.LENGTH_LONG).show()
                startActivity(Intent(this,ViewActivity::class.java))
            }
            else
            {
                Toast.makeText(applicationContext,"Error", Toast.LENGTH_LONG).show()
            }

        }
    }
}