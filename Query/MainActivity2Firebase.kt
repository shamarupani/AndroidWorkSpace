package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMain2FirebaseBinding
import com.example.myapplication.databinding.ActivityMainFirebaseBinding
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase





class MainActivity2Firebase : AppCompatActivity()
{
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter:MyAdapter
    private lateinit var binding: ActivityMain2FirebaseBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2FirebaseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        recyclerView = findViewById(R.id.recycler)

        val rl: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = rl

        val options = FirebaseRecyclerOptions.Builder<Model>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("android"), Model::class.java)
            .build()

        myAdapter =MyAdapter(options)
        recyclerView.adapter=myAdapter




    }
    override fun onStart() {
        super.onStart()
        myAdapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        myAdapter.stopListening()
    }

    override fun onRestart() {
        super.onRestart()
        myAdapter.startListening()
    }

    override fun onResume() {
        super.onResume()
        myAdapter.startListening()
    }

    override fun onPause() {
        super.onPause()
        myAdapter.stopListening()
    }


}