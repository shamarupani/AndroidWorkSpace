package com.example.employeetaskmanagement

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.SimpleAdapter
import com.example.employeetaskmanagement.databinding.ActivityProjectBinding
import com.example.employeetaskmanagement.databinding.ActivityProjectDashboardBinding

class ProjectDashboard : AppCompatActivity()
{
    private lateinit var binding: ActivityProjectDashboardBinding
    lateinit var dbhelperProject: DbHelper
    var list:List<Model_project> = ArrayList()
    var arraylist=ArrayList<HashMap<String,String>>()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbhelperProject=DbHelper(applicationContext)
        registerForContextMenu(binding.listProject)

        list=dbhelperProject.viewproject()

        for (i in list)
        {
            var hm=HashMap<String,String>()
            hm["TITLE"]=i.title
            hm["DESCRIPTION"]=i.desc
            arraylist.add(hm)
        }
        var from= arrayOf("TITLE","DESCRIPTION")
        var to= intArrayOf(R.id.title,R.id.desc)

        var adapter= SimpleAdapter(applicationContext,arraylist,R.layout.design_project,from,to)
        binding.listProject.adapter=adapter
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1:MenuItem= menu!!.add(0,1,0,"Update")
        var m2:MenuItem=menu.add(0,2,0,"Delete")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm:AdapterContextMenuInfo= item.menuInfo as AdapterContextMenuInfo
        var id=acm.position
        var user=list[id]

        when(item.itemId)
        {
            1->
            {
                var i= Intent(applicationContext,UpdateActivity::class.java)
                i.putExtra("id1",user.id)
                i.putExtra("title1",user.title)
                i.putExtra("desc1",user.desc)
                startActivity(i)
            }
            2->
            {
                var alert= AlertDialog.Builder(this)
                alert.setTitle("Are you sure you want to delete?")
                alert.setPositiveButton("YES",{
                        dialogInterface: DialogInterface, i: Int ->

                    dbhelperProject.deleteproject(user.id)
                    startActivity(Intent(this,ProjectDashboard::class.java))

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