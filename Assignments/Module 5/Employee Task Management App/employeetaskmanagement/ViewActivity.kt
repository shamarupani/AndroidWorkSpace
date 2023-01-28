package com.example.employeetaskmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import com.example.employeetaskmanagement.databinding.ActivityLoginBinding
import com.example.employeetaskmanagement.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityViewBinding
    lateinit var dbHelper: DbHelper
    var list:List<Model> =ArrayList()
    var arraylist= ArrayList<HashMap<String,String>>()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper=DbHelper(applicationContext)

        list=dbHelper.viewdata()

        for (i in list)
        {
            var hm=HashMap<String,String>()
            hm["FNAME"]=i.fname
            hm["LNAME"]=i.lname
            hm["UNAME"]=i.uname
            hm["EMAIL"]=i.email
            hm["PHONE"]=i.phone
            hm["PASSWORD"]=i.pwd

            arraylist.add(hm)
        }
        var from= arrayOf("FNAME","LNAME","UNAME","EMAIL","PHONE","PASSWORD")
        var to= intArrayOf(R.id.fname,R.id.lname,R.id.uname,R.id.email,R.id.phone,R.id.password)

        var adapter=SimpleAdapter(applicationContext,arraylist,R.layout.design,from,to)
        binding.list.adapter=adapter
    }
}