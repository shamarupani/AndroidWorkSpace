package com.example.module4assignments

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class MainActivit11thque : AppCompatActivity()
{
   lateinit var lnrDynamicEditTextHolder: LinearLayout
    lateinit var edtNoCreate: EditText
    lateinit var btnCreate: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_11thque)

        lnrDynamicEditTextHolder= findViewById(R.id.lnrDynamicEditTextHolder)
        edtNoCreate= findViewById(R.id.edtNoCreate)
        btnCreate= findViewById(R.id.btnCreate)
        btnCreate.setOnClickListener {

            var length=edtNoCreate.text.toString().toInt()
            for (i in 0 until length)
            {
                var edittext=EditText(this)
                edittext.id=i+1
                edittext.layoutParams= ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                edittext.hint="Edittext" + (i+1)
                lnrDynamicEditTextHolder.addView(edittext)
            }
        }




    }
}

