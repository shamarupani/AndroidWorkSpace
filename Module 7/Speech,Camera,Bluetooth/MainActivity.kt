package com.example.speechcamerabluetooth

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import java.util.*
import java.util.Locale.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var edt1:EditText
    lateinit var btn1:Button
    lateinit var tts:TextToSpeech
    lateinit var btn2:Button
    lateinit var img:ImageView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1=findViewById(R.id.edt1)
        btn1=findViewById(R.id.btn1)
        tts=TextToSpeech(applicationContext,this)
        btn2=findViewById(R.id.btn2)
        img=findViewById(R.id.img)

        btn1.setOnClickListener {
            var data1=edt1.text.toString()
            tts.speak(data1,QUEUE_ADD,null)
        }

       btn2.setOnClickListener {
           var i=Intent(ACTION_IMAGE_CAPTURE)
           startActivityForResult(i,1)
       }

    }

    override fun onInit(p0: Int)
    {
      tts.setLanguage(US)
      tts.setPitch(0.8F)
      tts.setSpeechRate(0.5F)
    }

   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
   {
       super.onActivityResult(requestCode, resultCode, data)
        var bm:Bitmap= data!!.extras!!.get("data") as Bitmap
        img.setImageBitmap(bm)
   }

}