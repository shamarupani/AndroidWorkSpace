package com.example.egreetings_admin.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.egreetings_admin.Adapter.DashboardAdapter
import com.example.egreetings_admin.ApiClient.ApiClient
import com.example.egreetings_admin.Interface.ApiInterface
import com.example.egreetings_admin.Model.DashboardModel
import com.example.egreetings_admin.R
import com.example.egreetings_admin.databinding.ActivityDashboardBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDashboardBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var apiInterface: ApiInterface
    lateinit var list: MutableList<DashboardModel>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        sharedPreferences=getSharedPreferences("user_session",Context.MODE_PRIVATE)
        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("mob",null), Toast.LENGTH_LONG).show()

        list=ArrayList()
        apiInterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        var layoutManager:RecyclerView.LayoutManager =GridLayoutManager(this,2)
        binding.recyclerDashboard.layoutManager=layoutManager

        var dashboardata : Call<List<DashboardModel?>?>? = apiInterface.dashboarview

        dashboardata!!.enqueue(object :Callback<List<DashboardModel?>?>
        {
            override fun onResponse(call: Call<List<DashboardModel?>?>, response: Response<List<DashboardModel?>?>) {

                list= response.body() as MutableList<DashboardModel>

                var adapter=DashboardAdapter(applicationContext,list)
                binding.recyclerDashboard.adapter=adapter
            }

            override fun onFailure(call: Call<List<DashboardModel?>?>, t: Throwable) {
                Toast.makeText(applicationContext,"Error in Data Fetching",Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}