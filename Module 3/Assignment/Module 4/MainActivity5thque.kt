package com.example.module4assignments

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.internal.ContextUtils.getActivity


class MainActivity5thque : AppCompatActivity() {
    lateinit var web: WebView
    lateinit var back: Button
    lateinit var forward: Button
    lateinit var progressBar: ProgressBar
    var url = "https://www.google.co.in/"

    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_5thque)

        forward =findViewById(R.id.forward)
        back=findViewById(R.id.back)
        web = findViewById(R.id.web)
        progressBar = findViewById(R.id.progressBar)

        web.webViewClient = myWebClient()
        web.settings.javaScriptEnabled = true
        web.settings.builtInZoomControls = true
        web.settings.displayZoomControls = false
        web.loadUrl(url)
        back.setOnClickListener { // TODO Auto-generated method stub
            if (web.canGoBack()) {
                web.goBack()
            }
        }
        forward.setOnClickListener { // TODO Auto-generated method stub
            if (web.canGoForward()) {
                web.goForward()
            }
        }
    }

    inner class myWebClient : WebViewClient() {
        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)


        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            progressBar.visibility = View.VISIBLE
            view.loadUrl(url)
            return true
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            progressBar.visibility = View.GONE
        }
    }
}



