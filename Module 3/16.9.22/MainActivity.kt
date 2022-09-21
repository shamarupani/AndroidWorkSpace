package com.example.customtoast


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.customtoast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var btn1:Button
    lateinit var btn2:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)

        //Custom Toast
        btn1.setOnClickListener {
            var t=Toast(this)
            var l=LayoutInflater.from(this)
            var v=l.inflate(R.layout.custom_toast,null)
            t.view=v
            t.setGravity(Gravity.CENTER,0,0)
            t.duration=Toast.LENGTH_LONG
            t.show()

        }
        //Custom Dialog
        btn2.setOnClickListener {
            var alert=AlertDialog.Builder(this)
            var l=LayoutInflater.from(this)
            var v=l.inflate(R.layout.custom_dialog,null)
            alert.setView(v)
            alert.show()
        }





    }
}