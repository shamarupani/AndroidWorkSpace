package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainFirebaseBinding
import com.google.firebase.database.FirebaseDatabase

class MainActivityFirebase : AppCompatActivity()
{
    private lateinit var binding: ActivityMainFirebaseBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFirebaseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    binding.btninsert.setOnClickListener {
        var name=binding.edt1.text.toString()
        var email=binding.edt2.text.toString()
        var pass=binding.edt3.text.toString()

        var map=HashMap<String,String>()
        map.put("n1",name)
        map.put("e1",email)
        map.put("p1",pass)

        var db= FirebaseDatabase.getInstance().getReference()
            .child("android")
            .setValue(map)
            .addOnSuccessListener {
                Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()
                startActivity(Intent(applicationContext, MainActivity2Firebase::class.java))
            }
            .addOnFailureListener {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }

    }
        binding.btnview.setOnClickListener {
            var i = Intent(this,MainActivity2Firebase::class.java)
            startActivity(i)
        }

    }
}