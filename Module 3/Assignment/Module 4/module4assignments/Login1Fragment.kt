package com.example.module4assignments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login1Fragment : Fragment() {
 lateinit var edt1:EditText
 lateinit var edt2:EditText
 lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_login1, container, false)
        edt1=view.findViewById(R.id.edt1)
        edt2=view.findViewById(R.id.edt2)
        btn1=view.findViewById(R.id.login)

        btn1.setOnClickListener {
            var n= edt1.text.toString()
            var p=edt2.text.toString()

            if(n.length==0 && p.length==0)
            {
                edt1.setError("Please Enter your Mobile Number")
                edt2.setError("Please Enter your Password")
            }
            else if (n.length==0)
            {
                edt1.setError("Please Enter your Mobile Number")
            }
            else if(p.length==0)
            {
                edt2.setError("Please Enter your Password")
            }
            else
            {
                if(n.equals("7405352712")&& p.equals("abc@123"))
                {
                    Toast.makeText(activity,"Login Success",Toast.LENGTH_LONG).show()

                }
                else
                {
                    Toast.makeText(activity,"Login Failed",Toast.LENGTH_LONG).show()
                }
            }
        }

        return  view
    }


    }
