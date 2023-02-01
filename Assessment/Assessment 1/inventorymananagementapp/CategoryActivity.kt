package com.example.inventorymananagementapp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.inventorymananagementapp.databinding.ActivityCategoryBinding


class CategoryActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityCategoryBinding
    lateinit var dbHelper: DbHelper
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dbHelper=DbHelper(applicationContext)

        binding.btnScan.setOnClickListener {
            var i=Intent(this,QrcodeScannActivity::class.java)
            startActivity(i)
        }

        binding.AddItem.setOnClickListener {
            var productname=binding.productname.text.toString()
            var productprice=binding.price.text.toString()
            var productcategory=binding.category.text.toString()
            var productnumber=binding.number.text.toString()

            var m=Model_product()
            m.product=productname
            m.price=productprice
            m.category=productcategory
            m.number=productnumber
            var id=dbHelper.insertproduct(m)

            if (id>0)
            {
                Toast.makeText(applicationContext,"Data Inserted"+id, Toast.LENGTH_LONG).show()

            }
            else
            {
                Toast.makeText(applicationContext,"Error"+id, Toast.LENGTH_LONG).show()
            }
        }
    }

}