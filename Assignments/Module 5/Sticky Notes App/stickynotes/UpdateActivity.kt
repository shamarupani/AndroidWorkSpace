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

class UpdateActivity : AppCompatActivity()
{
    lateinit var edtupdate:EditText
    lateinit var fabupdate:FloatingActionButton
    lateinit var dbHelper: DbHelper
    var id=0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        dbHelper=DbHelper(applicationContext)
        edtupdate=findViewById(R.id.edtupdate)
        fabupdate=findViewById(R.id.fabupdate)

        var i1=intent
        id=i1.getIntExtra("id1",101)
        edtupdate.setText(i1.getStringExtra("note1"))

        Toast.makeText(applicationContext,""+id, Toast.LENGTH_LONG).show()

        fabupdate.setOnClickListener {
            var note=edtupdate.text.toString()


            var m=Model()
            m.id=id
            m.note=note

            dbHelper.updatedata(m)
            startActivity(Intent(applicationContext,ViewActivity::class.java))
            updateWidget()
        }

    }

    private fun updateWidget() {
        val appWidgetManager = AppWidgetManager.getInstance(this)
        val remoteviews= RemoteViews(this!!.packageName,R.layout.widget_layout)
        val thisWidget = ComponentName(this, AppWidget::class.java)
        remoteviews.setTextViewText(R.id.textwidget, edtupdate!!.text.toString())
        appWidgetManager.updateAppWidget(thisWidget, remoteviews)
    }
}