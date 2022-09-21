package com.example.autocompspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var auto:AutoCompleteTextView
    var city= arrayOf("Rajkot","Surat","Jafarabad","Ahemdabad","Hyderabad")
    lateinit var spin:Spinner

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auto=findViewById(R.id.auto1)
        spin=findViewById(R.id.spin1)

        auto.threshold=2
        var adaptor1=ArrayAdapter(this,android.R.layout.select_dialog_item,city)
        auto.setAdapter(adaptor1)


        var adaptor2=ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,city)
        spin.adapter=adaptor2

        spin.setOnItemSelectedListener(this)



    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        Toast.makeText(this,"Selected City: "+city[position],Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}