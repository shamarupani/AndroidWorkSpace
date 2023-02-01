package com.example.inventorymananagementapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleAdapter
import com.example.inventorymananagementapp.databinding.ActivityProductViewBinding

class ProductViewActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityProductViewBinding
    lateinit var dbHelper: DbHelper
    var list:List<Model_product> = ArrayList()
    var arraylist=ArrayList<HashMap<String,String>>()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityProductViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper= DbHelper(applicationContext)

        list=dbHelper.viewproduct()

        for (i in list)
        {
            var hm=HashMap<String,String>()
            hm["PRODUCT"]=i.product
            hm["PRICE"]=i.price
            hm["CATEGORY"]=i.category
            hm["NUMBER"]=i.number

            arraylist.add(hm)
        }
        var from= arrayOf("PRODUCT","PRICE","CATEGORY","NUMBER")
        var to= intArrayOf(R.id.txt1,R.id.txt2,R.id.txt3,R.id.txt4)

        var adapter= SimpleAdapter(applicationContext,arraylist,R.layout.design2,from,to)
        binding.list.adapter=adapter


    }

}