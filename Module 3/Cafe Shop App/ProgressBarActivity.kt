package com.example.mynewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.Toast

class ProgressBarActivity : AppCompatActivity(), View.OnClickListener,
    RatingBar.OnRatingBarChangeListener {
    lateinit var pb1: ProgressBar
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var rtg1:RatingBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)
        pb1 = findViewById(R.id.pb1)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        rtg1=findViewById(R.id.rtg1)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        rtg1.setOnRatingBarChangeListener(this)

    }

    override fun onClick(v: View?) {
        if (v == btn1) {
            pb1.incrementProgressBy(1)
            setProgress(100 * pb1.progress)
        }
        if (v == btn2) {
            pb1.incrementProgressBy(-1)
            setProgress(100 * pb1.progress)
        }
    }

    override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
        var r=rtg1.rating
        Toast.makeText(applicationContext,""+r,Toast.LENGTH_LONG).show()
    }
}