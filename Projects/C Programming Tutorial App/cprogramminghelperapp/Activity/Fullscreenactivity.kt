package com.example.cprogramminghelperapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cprogramminghelperapp.Adapter.CategoryAdapter
import com.example.cprogramminghelperapp.Adapter.InnerCategoryAdapter
import com.example.cprogramminghelperapp.Client.ApiClient
import com.example.cprogramminghelperapp.Interface.ApiInterface
import com.example.cprogramminghelperapp.Model.Category_Model
import com.example.cprogramminghelperapp.Model.Inner_Category_Model
import com.example.cprogramminghelperapp.R
import com.example.cprogramminghelperapp.databinding.ActivityFullscreenactivityBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Fullscreenactivity : AppCompatActivity() {
    private lateinit var binding: ActivityFullscreenactivityBinding
    lateinit var apiInterface: ApiInterface
    lateinit var list: MutableList<Inner_Category_Model>
    var innercategorydata: Call<List<Inner_Category_Model?>?>? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullscreenactivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var i = intent
        var pos = i.getIntExtra("c_pos", 102)
        var dpos = i.getIntExtra("d_pos", 102)


        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerFullscreen.layoutManager = layoutManager


        list = ArrayList()

        if (dpos == 0)
        {
            if (pos == 0)
            {
                innercategorydata=apiInterface.introductionview
            }
            if (pos == 1)
            {
                innercategorydata=apiInterface.factsview
            }
        }

        if (dpos == 1)
        {
            if (pos == 0)
            {
                innercategorydata = apiInterface.basicview
            }
            if (pos == 1)
            {
                innercategorydata = apiInterface.advancedview
            }
        }
        if (dpos == 2)
        {
            if (pos == 0)
            {
                innercategorydata = apiInterface.interviewview
            }
        }

        if (dpos == 3)
        {
            if (pos == 0)
            {
                innercategorydata = apiInterface.innerpatternview
            }
        }
        innercategorydata!!.enqueue(object : Callback<List<Inner_Category_Model?>?>
        {
            override fun onResponse(call: Call<List<Inner_Category_Model?>?>, response: Response<List<Inner_Category_Model?>?>)
            {
                list= response.body() as MutableList<Inner_Category_Model>

                var adapter= InnerCategoryAdapter(applicationContext,list)
                binding.recyclerFullscreen.adapter=adapter
            }
            override fun onFailure(call: Call<List<Inner_Category_Model?>?>, t: Throwable) {
                Toast.makeText(applicationContext,"Error in data fetching",Toast.LENGTH_LONG).show()
            }
        })
    }
}

