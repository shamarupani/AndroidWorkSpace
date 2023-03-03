package com.example.cprogramminghelperapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cprogramminghelperapp.Adapter.CategoryAdapter
import com.example.cprogramminghelperapp.Client.ApiClient
import com.example.cprogramminghelperapp.Interface.ApiInterface
import com.example.cprogramminghelperapp.Model.Category_Model
import com.example.cprogramminghelperapp.databinding.ActivityCategoryBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityCategoryBinding
    lateinit var apiInterface: ApiInterface
    lateinit var list: MutableList<Category_Model>
    var categorydata: Call<List<Category_Model?>?>? =null


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i=intent
        var pos= i.getIntExtra("d_pos",101)
     //   Toast.makeText(applicationContext,""+pos, Toast.LENGTH_LONG).show()

        list=ArrayList()

        apiInterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        var layoutManager: RecyclerView.LayoutManager= GridLayoutManager(this,2)
        binding.recyclerCategory.layoutManager=layoutManager

        if (pos==0)
        {
            categorydata=apiInterface.tutorialview

        }
        if (pos==1)
        {
            categorydata=apiInterface.programview
        }
        if (pos==2)
        {
            categorydata=apiInterface.clanguagequestionsview
        }
        if (pos==3)
        {
            categorydata=apiInterface.patternview
        }



        categorydata!!.enqueue(object : Callback<List<Category_Model?>?>
        {
            override fun onResponse(call: Call<List<Category_Model?>?>, response: Response<List<Category_Model?>?>)
            {
                list= response.body() as MutableList<Category_Model>

                var adapter= CategoryAdapter(applicationContext,list,pos)
                binding.recyclerCategory.adapter=adapter
            }

            override fun onFailure(call: Call<List<Category_Model?>?>, t: Throwable) {
                Toast.makeText(applicationContext,"Error in data fetching",Toast.LENGTH_LONG).show()
            }

        })
    }
}