package com.example.stickynotes

import android.app.AlertDialog
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.RemoteViews
import android.widget.SimpleAdapter
import com.example.stickynotes.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity()

{
    lateinit var binding: ActivityViewBinding
    lateinit var dbHelper: DbHelper

    var list:List<Model> = ArrayList()
    var arraylist=ArrayList<HashMap<String,String>>()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dbHelper=DbHelper(applicationContext)
        list=dbHelper.viewdata()
        registerForContextMenu(binding.list)


        for (i in list)
        {
            var hm=HashMap<String,String>()
            hm["NOTE"]=i.note
            arraylist.add(hm)
        }
        var from= arrayOf("NOTE")
        var to= intArrayOf(R.id.txt1)
        var adapter= SimpleAdapter(applicationContext,arraylist,R.layout.design,from,to)
        binding.list.adapter=adapter
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1: MenuItem = menu!!.add(0,1,0,"Update")
        var m2: MenuItem =menu.add(0,2,0,"Delete")

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
                var i= Intent(applicationContext,UpdateActivity::class.java)
                i.putExtra("id1",user.id)
                i.putExtra("note1",user.note)

                startActivity(i)
            }
            2->
            {
                var alert= AlertDialog.Builder(this)
                alert.setTitle("Are you sure you want to delete?")
                alert.setPositiveButton("YES",{
                        dialogInterface: DialogInterface, i: Int ->

                    // Toast.makeText(applicationContext,""+id,Toast.LENGTH_LONG).show()
                    dbHelper.deletedata(user.id)
                    startActivity(Intent(this,ViewActivity::class.java))

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