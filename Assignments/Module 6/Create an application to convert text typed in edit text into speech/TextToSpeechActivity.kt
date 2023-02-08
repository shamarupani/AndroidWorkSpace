package com.example.module7assignments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import android.widget.Button
import android.widget.EditText
import java.util.*

class TextToSpeechActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var edt1: EditText
    lateinit var btn1: Button
    lateinit var tts:TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_to_speech)

        edt1 = findViewById(R.id.edt1)
        btn1 = findViewById(R.id.btn1)
        tts= TextToSpeech(applicationContext,this)

        btn1.setOnClickListener {
            var data=edt1.text.toString()
            tts.speak(data,QUEUE_ADD,null)
        }
    }

    override fun onInit(status: Int)
    {
        tts.setLanguage(Locale.US)
        tts.setPitch(0.8F)
        tts.setSpeechRate(0.5F)
    }
}