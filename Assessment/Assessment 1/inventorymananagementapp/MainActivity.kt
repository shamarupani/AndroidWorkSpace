package com.example.inventorymananagementapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.inventorymananagementapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var dbHelper: DbHelper

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper=DbHelper(applicationContext)
        var db=dbHelper.readableDatabase

        binding.btnNewUser.setOnClickListener {
            startActivity(Intent(applicationContext,RegistrationActivity::class.java))
        }
        binding.btnlogin.setOnClickListener {
            var uname = binding.edtname.text.toString()
            var password = binding.edtpass.text.toString()

            var query="SELECT * FROM details WHERE uname='"+uname+"' AND pwd='"+password+"'"
            var rs=db.rawQuery(query,null)
            if (rs.moveToFirst())
            {
                var uname=rs.getString(rs.getColumnIndex("uname"))
                rs.close()
                Toast.makeText(applicationContext,"Welcome "+uname,Toast.LENGTH_LONG).show()
                var i= Intent(this,MainActivity2::class.java)
                i.putExtra("name",uname)
                startActivity(i)
            }
            else
            {
                var ad = AlertDialog.Builder(this)
                ad.setTitle("Message")
                ad.setMessage("Username or password is incorrect!")
                ad.setPositiveButton("Ok", null)
                ad.show()
            }  }


    }
}