package com.example.foodfeed

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.foodfeed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Model>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()
        list.add(Model(R.drawable.panipuri, "Pani Puri", "Netri Pani Puri", "₹50", "5.0/5"))
        list.add(Model(R.drawable.sandwich, "Sandwich", "Balaji Sandwich", "₹40", "5.0/5"))
        list.add(Model(R.drawable.samosa, "Samosa", "Desi Palace", "₹40", "4.0/5"))
        list.add(Model(R.drawable.vadapav, "VadaPav", "Mumbai Snacks", "₹50", "4.5/5"))
        list.add(Model(R.drawable.dabeli, "Dabeli", "Shree Kutchi Dabeli", "₹35", "3.5/5"))
        list.add(Model(R.drawable.frankie, "Frankie", "Frankie Nation", "₹60", "3.0/5"))
        list.add(Model(R.drawable.burger, "Burger", "Dhakka mukki eatery", "₹50", "4.0/5"))
        list.add(Model(R.drawable.pizza, "Pizza", "Spedito Pizzeria", "₹200", "4.0/5"))
        list.add(Model(R.drawable.frenchfries, "French Fries", "Cheese & Chips Rajkot","₹70", "4.5/5"))


        var adapter1 = MyAdapter(this, list)
        binding.list1.adapter = adapter1

    }
}
