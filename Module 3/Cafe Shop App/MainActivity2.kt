package com.example.mynewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    lateinit var chk1:CheckBox
    lateinit var chk2:CheckBox
    lateinit var chk3:CheckBox
    lateinit var btn1:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        chk1=findViewById(R.id.chk1)
        chk2=findViewById(R.id.chk2)
        chk3=findViewById(R.id.chk3)
        btn1=findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var amount=0
            var builder=StringBuilder()
            builder.append("\n Selected Items:\n")

            if (chk1.isChecked)
            {
                builder.append("\n Ice cream @ 60 \n")
                amount+=60
            }
            if (chk2.isChecked)
            {
                builder.append("\n Choclate @50 \n")
                amount+=50
            }
            if (chk3.isChecked)
            {
                builder.append("\n C0ffee @ 70")
                amount+=70
            }
            builder.append("\n Total: \n"+amount    )
           // Toast.makeText(applicationContext,""+builder.toString(),Toast.LENGTH_LONG).show()

            var i=Intent(this,MainActivity3::class.java)
            i.putExtra("Bill",builder.toString())
            startActivity(i)
        }

        }

    override fun onBackPressed() {
        finishAffinity()
    }
}