package com.example.speechcamerabluetooth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SmsActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        edt1=findViewById(R.id.edt1)
        edt2=findViewById(R.id.edt2)
        btn1=findViewById(R.id.btn1)

        btn1.setOnClickListener {
            var num=edt1.text.toString()
            var msg=edt2.text.toString()

            var manager:SmsManager=SmsManager.getDefault()
            manager.sendTextMessage(num,null,msg,null,null)

            Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
        }
    }
}