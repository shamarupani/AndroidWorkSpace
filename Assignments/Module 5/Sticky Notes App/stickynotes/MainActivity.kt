package com.example.stickynotes


import android.annotation.SuppressLint
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.EditText
import android.widget.RemoteViews
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity()
{

    lateinit var dbHelper: DbHelper
    lateinit var edittext: EditText
    lateinit var fab:FloatingActionButton
    lateinit var fabview:FloatingActionButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper=DbHelper(applicationContext)
        fabview=findViewById(R.id.fabview)
        edittext=findViewById(R.id.edttext)
        fab=findViewById(R.id.fab)

        fabview.setOnClickListener {
            startActivity(Intent(this,ViewActivity::class.java))
        }
        fab.setOnClickListener {

                var note=edittext.text.toString()
                var m=Model()
                m.note=note
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
                updateWidget()
                Toast.makeText(this, "Updated Successfully!!", Toast.LENGTH_SHORT).show()
            }

    }

    private fun updateWidget()
    {
        val appWidgetManager = AppWidgetManager.getInstance(this)
        val remoteviews=RemoteViews(this!!.packageName,R.layout.widget_layout)
        val thisWidget = ComponentName(this, AppWidget::class.java)
        remoteviews.setTextViewText(R.id.textwidget, edittext!!.text.toString())
        appWidgetManager.updateAppWidget(thisWidget, remoteviews)
    }
}