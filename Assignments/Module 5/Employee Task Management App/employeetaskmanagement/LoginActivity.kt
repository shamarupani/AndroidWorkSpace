package com.example.employeetaskmanagement

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.employeetaskmanagement.databinding.ActivityLoginBinding
import com.example.employeetaskmanagement.databinding.ActivityRegistrationBinding

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding
    lateinit var dbHelper: DbHelper
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper=DbHelper(applicationContext)
        var db=dbHelper.readableDatabase

        binding.btnNewUser.setOnClickListener {
            startActivity(Intent(applicationContext,RegistrationActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            var uname = binding.username.text.toString()
            var password = binding.password.text.toString()

            var query="SELECT * FROM details WHERE uname='"+uname+"' AND pwd='"+password+"'"
            var rs=db.rawQuery(query,null)
            if (rs.moveToFirst())
            {
                var uname=rs.getString(rs.getColumnIndex("uname"))
                rs.close()
                Toast.makeText(applicationContext,"Welcome "+uname,Toast.LENGTH_LONG).show()
                var i= Intent(this,DashboardActivity::class.java)
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
            }

        }


    }
}