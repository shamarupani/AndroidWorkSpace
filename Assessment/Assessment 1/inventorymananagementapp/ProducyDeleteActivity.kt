package com.example.inventorymananagementapp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.example.inventorymananagementapp.databinding.ActivityProductViewBinding
import com.example.inventorymananagementapp.databinding.ActivityProducyDeleteBinding

class ProducyDeleteActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityProducyDeleteBinding
    lateinit var dbHelper: DbHelper
    var list:List<Model_product> = ArrayList()
    var arraylist=ArrayList<HashMap<String,String>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProducyDeleteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper= DbHelper(applicationContext)

        list=dbHelper.viewproduct()
        registerForContextMenu(binding.list)
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
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1: MenuItem = menu!!.add(0,1,0,"Delete")


        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm: AdapterView.AdapterContextMenuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
        var id=acm.position
        var user=list[id]


        when(item.itemId)
        {
            1->

            {
                var alert= AlertDialog.Builder(this)
                alert.setTitle("Are you sure you want to delete?")
                alert.setPositiveButton("YES",{
                        dialogInterface: DialogInterface, i: Int ->

                    dbHelper.deleteproduct(user.id2)
                    startActivity(Intent(this,ProductViewActivity::class.java))
                })
                alert.setNegativeButton("NO",{
                        dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()
                })
                alert.show()
            }
        }
        return super.onContextItemSelected(item)
    }


}