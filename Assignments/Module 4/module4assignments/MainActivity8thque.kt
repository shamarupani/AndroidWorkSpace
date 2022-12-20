package com.example.module4assignments

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class MainActivity8thque : AppCompatActivity()
{
    lateinit var tableLayout: TableLayout
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_8thque)

        tableLayout=findViewById(R.id.tablelayout)

          var tableRow=TableRow(this)
          var textview=TextView(this)

          textview.setText("This is text")

          tableLayout.addView(tableRow)
          tableRow.addView(textview)
    }
}