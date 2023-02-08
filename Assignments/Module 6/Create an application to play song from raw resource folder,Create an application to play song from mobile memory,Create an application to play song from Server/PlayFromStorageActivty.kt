package com.example.module7assignments

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class PlayFromStorageActivty : AppCompatActivity()
{
    lateinit var mediaPlayer: MediaPlayer
    lateinit var imagebutton:ImageButton

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_from_storage)

        imagebutton = findViewById(R.id.imageButton)
        mediaPlayer = MediaPlayer()
        checkPermission1()
        var path = "/storage/emulated/"
         var mPlayer =  MediaPlayer()
        try {
            mPlayer.setDataSource(path+"/0/Abc.mp3")
            mPlayer.prepare()
        } catch (e:IllegalArgumentException) {
            e.printStackTrace()
        }
        mPlayer.start()

    }
    private fun checkPermission1() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    123)
            }
        }
    }
}