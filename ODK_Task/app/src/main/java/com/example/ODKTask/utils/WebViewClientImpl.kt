package com.example.ODKTask.utils

import android.app.Activity
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar


class WebViewClientImpl(private var activity: Activity, var pDialog: ProgressBar) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        pDialog.visibility = View.VISIBLE
        return true
    }

    override fun onPageFinished(view: WebView, url: String) {
        //view.loadUrl(url);
        println("on finish")
        pDialog.visibility = View.GONE

    }
}