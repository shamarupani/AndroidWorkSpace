package com.example.module4assignments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        edt1=findViewById(R.id.edt1)
       edt2=findViewById(R.id.edt2)
        btn1=findViewById(R.id.btn1)



        btn1.setOnClickListener {

            val bundle = Bundle()
            var i=0
            var first=edt1.text.toString()
            var second=edt2.text.toString()
             var a= Integer.parseInt(first)
             var b= Integer.parseInt(second)
            for (i in a..b)
            {

                println(i)

                bundle.putString("first",first)
            }

          //  bundle.putString("second",second)


            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)




            }




        }
}
