package com.example.module7assignments


import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class WakeLockActivity : AppCompatActivity()
{
   private var videoView: VideoView? =null
   private var mediaController: MediaController? =null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wake_lock)

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

             videoView=findViewById(R.id.videoview)
        setupVideoPlayer()

    }



    private fun setupVideoPlayer() {
        if (mediaController == null)
        {
            mediaController=MediaController(this)
            mediaController!!.setAnchorView(this.videoView)
        }
        videoView!!.setMediaController(mediaController)
        videoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.file))
        videoView!!.requestFocus()
        videoView!!.pause()
        videoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext,"Video completed",Toast.LENGTH_LONG).show()
        }
        videoView!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
            false
        }
    }
}