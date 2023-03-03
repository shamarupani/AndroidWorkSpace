package com.example.cprogramminghelperapp.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cprogramminghelperapp.Adapter.DashboardAdapter
import com.example.cprogramminghelperapp.Client.ApiClient
import com.example.cprogramminghelperapp.Interface.ApiInterface
import com.example.cprogramminghelperapp.Model.Dashboard_Model
import com.example.cprogramminghelperapp.R
import com.example.cprogramminghelperapp.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : Fragment()
{
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    lateinit var apiInterface: ApiInterface
    lateinit var list: MutableList<Dashboard_Model>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        list=ArrayList()

        var layout:RecyclerView.LayoutManager= GridLayoutManager(activity,2)
        binding.recycler.layoutManager=layout


        apiInterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        var dashboardview:Call<List<Dashboard_Model>> = apiInterface.dashboarddetail

        dashboardview.enqueue(object :Callback<List<Dashboard_Model>>
        {
            override fun onResponse(call: Call<List<Dashboard_Model>>, response: Response<List<Dashboard_Model>>)
            {
                list= response.body() as MutableList<Dashboard_Model>
                var myAdapter= DashboardAdapter(requireActivity(),list)
                binding.recycler.adapter=myAdapter
            }

            override fun onFailure(call: Call<List<Dashboard_Model>>, t: Throwable) {
                Toast.makeText(activity,"Error in data fetching",Toast.LENGTH_LONG).show()
            }
        })

        return view
    }


}