package com.example.e_greetings.Activity

import android.annotation.SuppressLint
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
import com.example.e_greetings.Adapter.DashboardAdapter
import com.example.e_greetings.Client.ApiClient
import com.example.e_greetings.Interface.ApiInterface
import com.example.e_greetings.Model.Dashboard_Model
import com.example.e_greetings.R
import com.example.e_greetings.databinding.ActivityDashboardBinding
import com.example.e_greetings.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDashboardBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var apiInterface: ApiInterface
    lateinit var list: MutableList<Dashboard_Model>

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE)
        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("mob",null),Toast.LENGTH_LONG).show()

        list=ArrayList()

        var layoutManager:RecyclerView.LayoutManager=GridLayoutManager(this,2)
        binding.recyclerDashboard.layoutManager=layoutManager

        apiInterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        var dashdoardview:Call<List<Dashboard_Model?>?>? = apiInterface.dashboardview
        dashdoardview!!.enqueue(object:Callback<List<Dashboard_Model?>?>
        {
            override fun onResponse(call: Call<List<Dashboard_Model?>?>, response: Response<List<Dashboard_Model?>?>)
            {
                list= response.body() as MutableList<Dashboard_Model>
                var dashboardadapter=DashboardAdapter(applicationContext,list)
                binding.recyclerDashboard.adapter=dashboardadapter
            }

            override fun onFailure(call: Call<List<Dashboard_Model?>?>, t: Throwable)
            {
                Toast.makeText(applicationContext,"Error in data fetching",Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                startActivity(Intent(this,LoginActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finishAffinity()
        super.onBackPressed()
    }
}

