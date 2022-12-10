package com.example.module4assignments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.module4assignments.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment()
{
    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(inflater,container,false)

       binding.btn.setOnClickListener {
           var a=   binding.edt1.text.toString()
           var b=   binding.edt2.text.toString()
           var c=  binding.edt3.text.toString()
           var d=  binding.edt4.text.toString()
           var i=binding.r1.text.toString()
           var j=binding.r2.text.toString()
           var f=  binding.edt6.text.toString()
           var g=  binding.edt7.text.toString()
           var h=  binding.edt8.text.toString()


           if (a.length==0 && b.length==0 && c.length==0 && d.length==0 && f.length==0 && g.length==0 && h.length==0)
           {

               binding.edt1.setError("Enter your First Name")
               binding.edt2.setError("Enter your Last Name")
               binding.edt3.setError("Enter your Email Address")
               binding.edt4.setError("Enter your Mobile Number")
               binding.edt6.setError("Enter your City")
               binding.edt7.setError("Enter your Password")
               binding.edt8.setError("Please Confirm Password")
           }
           else if (a.length==0)
           {
               binding.edt1.setError("Enter your First Name")
           }
           else if (b.length==0)
           {
               binding.edt2.setError("Enter your Last Name")
           }
           else if (c.length==0)
           {
               binding.edt3.setError("Enter your Email Address")
           }
           else if (d.length==0)
           {
               binding.edt4.setError("Enter your Mobile Number")
           }
           else if (f.length==0)
           {
               binding.edt6.setError("Enter your City")
           }
           else if (g.length==0)
           {
               binding.edt6.setError("Please Confirm Password")
           }
           else
           {
               if (a.equals("Shama")&& b.equals("Rupani")&& c.equals("shama.rupani@gmail.com") && d.equals("7405352712") && f.equals("rajkot") && g.equals("abc@123"))
               {
                   Toast.makeText(activity,"Registration Success",Toast.LENGTH_LONG).show()

               }
               else
               {
                   Toast.makeText(activity,"Registration Failed",Toast.LENGTH_LONG).show()
               }
           }
       }

        return binding.getRoot();
    }

}

