package com.example.module4assignments

import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.module4assignments.databinding.ActivityMain3rdqueBinding


class MainActivity3rdque : AppCompatActivity()
{
    private lateinit var binding: ActivityMain3rdqueBinding
    var answer:Int = 0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3rdqueBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {

        var firstNumberValue = Integer.parseInt(binding.edt1.getText().toString())
        var secondNumberValue = Integer.parseInt(binding.edt2.getText().toString())
        var operatorButtonId = binding.operators.getCheckedRadioButtonId()


        if(operatorButtonId == binding.rb1.getId())
        {
            answer = firstNumberValue + secondNumberValue
        }
        else if(operatorButtonId == binding.rb2.getId())
        {
            answer = firstNumberValue - secondNumberValue
        }
        else if(operatorButtonId == binding.rb3.getId())
        {
            answer = firstNumberValue * secondNumberValue
        }
        else if(operatorButtonId == binding.rb4.getId())
        {
            answer = firstNumberValue / secondNumberValue
        }
            binding.result.setText(answer.toString())
    }

    }
}