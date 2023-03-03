package com.example.e_greetings.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.e_greetings.Adapter.CategoryAdapter
import com.example.e_greetings.Client.ApiClient
import com.example.e_greetings.Interface.ApiInterface
import com.example.e_greetings.Model.Category_Model
import com.example.e_greetings.R
import com.example.e_greetings.databinding.ActivityCategoryBinding
import com.example.e_greetings.databinding.ActivityDashboardBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityCategoryBinding
    lateinit var apiInterface: ApiInterface
    lateinit var list: MutableList<Category_Model>
    var categorydata:Call<List<Category_Model?>?>? =null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i=intent
        var pos= i.getIntExtra("c_pos",101)
        Toast.makeText(applicationContext,""+pos,Toast.LENGTH_LONG).show()

        list=ArrayList()

        apiInterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        var layoutManager:RecyclerView.LayoutManager=GridLayoutManager(this,2)
        binding.recyclerCategory.layoutManager=layoutManager

        if (pos==0)
        {
            categorydata=apiInterface.birthdayview
        }
        if (pos==1)
        {
            categorydata = apiInterface.eidview
        }
        if (pos==2)
        {
            categorydata = apiInterface.holiview
        }
        if (pos==3)
        {
            categorydata = apiInterface.anniversaryview
        }
        if (pos==4)
        {
            categorydata =apiInterface.diwaliview
        }

        categorydata!!.enqueue(object :Callback<List<Category_Model?>?>
        {
            override fun onResponse(call: Call<List<Category_Model?>?>, response: Response<List<Category_Model?>?>)
            {
               list= response.body() as MutableList<Category_Model>

                var adapter=CategoryAdapter(applicationContext,list)
                binding.recyclerCategory.adapter=adapter
            }

            override fun onFailure(call: Call<List<Category_Model?>?>, t: Throwable) {
                Toast.makeText(applicationContext,"Error in data fetching",Toast.LENGTH_LONG).show()
            }

        })
    }
}