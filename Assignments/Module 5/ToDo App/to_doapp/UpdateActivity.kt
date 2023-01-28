package com.example.to_doapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.to_doapp.databinding.ActivityMainBinding
import com.example.to_doapp.databinding.ActivityUpdateBinding
import com.example.to_doapp.databinding.ActivityViewBinding

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateBinding
    lateinit var dbHelper: DbHelper
    var id=0
    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper = DbHelper(applicationContext)
        var i1=intent
        id=i1.getIntExtra("id1",101)
        binding.taskedit.setText(i1.getStringExtra("title1"))

        Toast.makeText(applicationContext,""+id,Toast.LENGTH_LONG).show()

        binding.btnupdate.setOnClickListener {
            var uname=binding.taskedit.text.toString()

            var m=Model()
            m.id=id
            m.title=uname

            dbHelper.updatedata(m)
            startActivity(Intent(applicationContext,ViewActivity::class.java))
        }
    }


    }
