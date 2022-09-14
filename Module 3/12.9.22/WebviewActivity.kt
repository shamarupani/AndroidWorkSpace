package com.example.mynewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebviewActivity : AppCompatActivity() {
    lateinit var web1:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        web1=findViewById(R.id.web1)
        web1.loadUrl("https://www.tutorialspoint.com/android/index.htm")
    }
}