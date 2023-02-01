package com.example.inventorymananagementapp

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inventorymananagementapp.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding
    lateinit var list: MutableList<Model1>

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list=ArrayList()
        var layout:RecyclerView.LayoutManager=GridLayoutManager(this,2)
        binding.recycler.layoutManager=layout

        list.add(Model1(R.drawable.add,"Add Product"))
        list.add(Model1(R.drawable.delete,"Delete Product"))
        list.add(Model1(R.drawable.view,"View Product"))
        list.add(Model1(R.drawable.viewinventory,"View Inventory"))

        var myAdapter= MyAdapter(this,list)
        binding.recycler.adapter=myAdapter

        var i=intent
        var pos= i.getIntExtra("c_pos",101)

        if (pos==0)
        {

            var i=Intent(applicationContext,CategoryActivity::class.java)
            startActivity(i)
        }
        if (pos==1)
        {

            var i=Intent(applicationContext,ProducyDeleteActivity::class.java)
            startActivity(i)
        }
        if (pos==2)
        {

            var i=Intent(applicationContext,ProductViewActivity::class.java)
            startActivity(i)
        }
        if (pos==3)
        {

            var i=Intent(applicationContext,QrcodeScannActivity::class.java)
            startActivity(i)
        }
    }

    override fun onBackPressed() {
        var builder= AlertDialog.Builder(this)
        builder.setCancelable(false)
        builder.setMessage("Do you want to Exit?")
        builder.setPositiveButton("Yes",
            DialogInterface.OnClickListener { dialog, which -> //if user pressed "yes", then he is allowed to exit from application
                finish()
            })
        builder.setNegativeButton("No",
            DialogInterface.OnClickListener { dialog, which -> //if user select "No", just cancel this dialog and continue with app
                dialog.cancel()
            })
        val alert: AlertDialog = builder.create()
        alert.show()
    }
}