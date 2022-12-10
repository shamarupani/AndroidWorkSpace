package com.example.roomdb.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Database
import androidx.room.Room
import com.example.roomdb.Database.DatabaseClass
import com.example.roomdb.Entity.User
import com.example.roomdb.GlobalVariables.GlobalVariables
import com.example.roomdb.R

class AddUserActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    var db:DatabaseClass ? =null
    var mContext: Context? =null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        edt1=findViewById(R.id.edt1)
        edt2=findViewById(R.id.edt2)
        btn1=findViewById(R.id.btn1)
        mContext=this

        val db = Room.databaseBuilder(
            applicationContext, DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()

         if (GlobalVariables.updateFlag.equals("update"))
          {
               edt1.setText(GlobalVariables.name)
               edt2.setText(GlobalVariables.email)
          }

        btn1.setOnClickListener {

            var name1=edt1.text.toString()
            var email1=edt2.text.toString()

            if (name1.length>0 && email1.length>0)
            {
                if (GlobalVariables.updateFlag.equals("update"))
                {
                    var u = User()
                    u.id = GlobalVariables.id
                    u.name = name1
                    u.email = email1

                    db.daoClass().updateUser(u)
                    Toast.makeText(mContext, "Successful", Toast.LENGTH_LONG).show()
                    GlobalVariables.updateFlag = ""
                    startActivity(Intent(this, MainActivity::class.java))

                }
                else
                {
                    var u = User()
                    u.name = name1
                    u.email = email1

                    db.daoClass().addUser(u)
                    Toast.makeText(mContext, "Successful", Toast.LENGTH_LONG).show()
                    var i=Intent(this,MainActivity::class.java)
                    startActivity(i)
                }
            }
        }
    }
}