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
import com.example.jsonparsinginsertview.databinding.ActivityInsertBinding
import org.json.JSONException

class InsertActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityInsertBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btninsert.setOnClickListener {
             var name=binding.edt1.text.toString()
             var standard=binding.edt2.text.toString()
             var age=binding.edt3.text.toString()

            var stringRequest:StringRequest=object:StringRequest(Request.Method.POST,"https://shamarayani.000webhostapp.com/student_api/insert.php",
            Response.Listener {
                try
                {
                    Toast.makeText(applicationContext,"Data Inserted",Toast.LENGTH_LONG).show()
                    var i=Intent(this,ViewActivity::class.java)
                    startActivity(i)
                }
                catch (e:JSONException)
                {
                    Log.d("Error",e.message.toString())
                }
            }, Response.ErrorListener {
                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                })
            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map=HashMap<String,String>()
                    map["name"]=name
                    map["standard"]=standard
                    map["age"]=age

                    return map
                }
            }
            var queue:RequestQueue=Volley.newRequestQueue(this@InsertActivity)
            queue.add(stringRequest)
        }
    }
}