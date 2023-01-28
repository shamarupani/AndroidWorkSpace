package com.example.to_doapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.to_doapp.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityViewBinding
    lateinit var dbHelper: DbHelper
    var list:List<Model> = ArrayList()
    var arraylist=ArrayList<HashMap<String,String>>()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        registerForContextMenu(binding.list)

        dbHelper= DbHelper(applicationContext)
        list=dbHelper.viewdata()
     for (i in list)
        {
            var hm=HashMap<String,String>()
            hm["TITLE"]=i.title

            arraylist.add(hm)
        }
        var from= arrayOf("TITLE")
        var to= intArrayOf(R.id.txt1)

        var adapter= SimpleAdapter(applicationContext,arraylist,R.layout.design,from,to)
        binding.list.adapter=adapter

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1:MenuItem= menu!!.add(0,1,0,"Update")
        var m2:MenuItem=menu.add(0,2,0,"Delete")
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

                var i=Intent(applicationContext,UpdateActivity::class.java)
                i.putExtra("id1",user.id)
                i.putExtra("title1",user.title)

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