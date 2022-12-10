package com.example.jsonparsinginsertview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonparsinginsertview.databinding.ActivityUpdateJsonBinding
import org.json.JSONException

class UpdateJsonActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateJsonBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateJsonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i=intent
        var id= i.getIntExtra("id",101)
        binding.edt1.setText( i.getStringExtra("name"))
        binding.edt2.setText(i.getStringExtra("standard"))
        binding.edt3.setText(i.getStringExtra("age"))

        binding.btnupdate.setOnClickListener {
            var name=binding.edt1.text.toString()
            var standard=binding.edt2.text.toString()
            var age=binding.edt3.text.toString()

            var stringRequest: StringRequest =object: StringRequest(Request.Method.POST,"https://shamarayani.000webhostapp.com/student_api/update.php",
                Response.Listener {
                    try
                    {
                        Toast.makeText(applicationContext,"Data Updated", Toast.LENGTH_LONG).show()
                        var i= Intent(this,ViewActivity::class.java)
                        startActivity(i)
                    }
                    catch (e: JSONException)
                    {
                        Log.d("Error",e.message.toString())
                    }
                }, Response.ErrorListener {
                    Toast.makeText(applicationContext,"No Internet", Toast.LENGTH_LONG).show()
                })
            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map=HashMap<String,String>()
                    map["id"]= id.toString()
                    map["name"]=name
                    map["standard"]=standard
                    map["age"]=age

                    return map
                }
            }
            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)
        }
        }
    }
