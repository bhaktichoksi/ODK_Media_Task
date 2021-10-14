package com.example.ODKTask.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.example.ODKTask.R
import com.example.ODKTask.utils.WebViewClientImpl
import kotlinx.android.synthetic.main.activity_web_view.*
import android.webkit.WebView

import android.webkit.WebSettings.PluginState

import android.webkit.WebChromeClient


class WebViewActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val url = intent.getStringExtra("url")

        val webSettings = webview.settings
        webSettings.javaScriptEnabled = true

        webview.webViewClient = WebViewClientImpl(this,pDialog)
        webview.webChromeClient = WebChromeClient()

        webview.settings.javaScriptEnabled = true
        webview.settings.pluginState = PluginState.ON
        webview.settings.builtInZoomControls = false
        webview.settings.setSupportZoom(false)

        webview.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        webview.isScrollbarFadingEnabled = false

        webview.setInitialScale(100)
        webview.loadUrl(url!!)

//            webview.loadUrl(url)

    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && this.webview.canGoBack()) {
            this.webview.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


}
