package com.example.module7assignments

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class PlayFromServerActivity : AppCompatActivity(), MediaPlayer.OnPreparedListener {
    var url="https://shamarayani.000webhostapp.com/miley_cyrus_flowers.mp3"
    lateinit var mediaPlayer: MediaPlayer
    lateinit var imageButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_from_server)

        imageButton=findViewById(R.id.imageButton)
        mediaPlayer= MediaPlayer()
        imageButton.setOnClickListener {
            mediaPlayer=MediaPlayer()
            mediaPlayer.setDataSource(url)
            mediaPlayer.prepareAsync()
            mediaPlayer.setOnPreparedListener(this)
        }

    }

    override fun onPrepared(mp: MediaPlayer?) {

        mediaPlayer.start()
    }
}