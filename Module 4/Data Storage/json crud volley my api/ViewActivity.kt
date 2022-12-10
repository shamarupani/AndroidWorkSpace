package com.example.jsonparsinginsertview

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonparsinginsertview.databinding.ActivityViewBinding
import org.json.JSONArray
import org.json.JSONException

class ViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewBinding
    lateinit var list: MutableList<Model_json>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        list = ArrayList()
        registerForContextMenu(binding.list)



        var stringRequest = StringRequest(Request.Method.POST,
            "https://shamarayani.000webhostapp.com/student_api/view.php",
            { response ->
                try {
                    var jsonArray = JSONArray(response)
                    for (i in 0 until jsonArray.length()) {
                        var jsonObject = jsonArray.getJSONObject(i)


                        var m = Model_json()
                        m.id = jsonObject.getInt("id")
                        m.name = jsonObject.getString("name")
                        m.standard = jsonObject.getString("standard")
                        m.age = jsonObject.getString("age")
                        list.add(m)

                    }
                } catch (e: JSONException) {
                    Log.d("Error", e.message.toString())
                }
                var adapter = adapter(this, list)
                binding.list.adapter = adapter

            })
        {
            Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()
        }
        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        var m1 = menu!!.add(0, 1, 0,"Update")
        var m2 = menu!!.add(0, 2, 0,"Delete")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var acm: AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var id = acm.position

        var m = list[id]

        when (item.itemId) {
            1 -> {
                var i = Intent(this, UpdateJsonActivity::class.java)
                i.putExtra("id", m.id)
                i.putExtra("name", m.name)
                i.putExtra("standard", m.standard)
                i.putExtra("age", m.age)
                startActivity(i)
            }
            2 -> {
                var alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Are you sure you want to Delete?")
                alertDialog.setPositiveButton("YES", { dialogInterface: DialogInterface, i: Int ->

                    var stringRequest: StringRequest = object : StringRequest(Request.Method.POST,
                        "https://shamarayani.000webhostapp.com/student_api/delete.php",
                        Response.Listener {

                            try {
                                Toast.makeText(
                                    applicationContext,
                                    "Data Deleted",
                                    Toast.LENGTH_LONG
                                ).show()
                                var i = Intent(this, ViewActivity::class.java)
                                startActivity(i)
                            } catch (e: JSONException) {
                                Log.d("Error", e.message.toString())
                            }
                        },
                        Response.ErrorListener {
                            Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG)
                                .show()

                        }) {
                        override fun getParams(): MutableMap<String, String>? {
                            var map = HashMap<String, String>()
                            map["id"] = m.id.toString()

                            return map
                        }

                    }
                    var queue: RequestQueue = Volley.newRequestQueue(this)
                    queue.add(stringRequest)

                })
                alertDialog.setNegativeButton("NO", { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.cancel()
                })
                alertDialog.show()
            }
        }
        return super.onContextItemSelected(item)
    }
}
