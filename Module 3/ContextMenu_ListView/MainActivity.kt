package com.example.contextmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity()
{

    lateinit var listView: ListView
    lateinit var list: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView=findViewById(R.id.list1)

        list=ArrayList()

        list.add("A")
        list.add("B")
        list.add("C")
        list.add("D")



        registerForContextMenu(listView)
        var adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        listView.adapter=adapter1



    }
        //ContextMenu this function works outside onCreate function
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {

        menuInflater.inflate(R.menu.context,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

      var acm:AdapterView.AdapterContextMenuInfo=item.menuInfo as AdapterView.AdapterContextMenuInfo
        var pos=acm.position
        when(item.itemId) {
            R.id.item1 -> {
                Toast.makeText(applicationContext,""+pos,Toast.LENGTH_LONG).show()
            }
        }

        return super.onContextItemSelected(item)
    }
   

}
