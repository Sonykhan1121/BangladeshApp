package com.example.bangladesh

import android.app.ProgressDialog
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.bangladesh.databinding.ActivityDistrictWikiBinding

class DistrictWikiActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDistrictWikiBinding
    private lateinit var processdialog:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDistrictWikiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title  = intent.getStringExtra("selectedItem")
        val bname = intent.getStringExtra("banglaname")
        binding.titleIdDistrictWiki.setText(title)

        //initiazie processdialog
            processdialog = ProgressDialog(this)
        processdialog.setMessage("Loading Page ....")
        processdialog.setCancelable(false)


        binding.webviewWiki.webViewClient =  object :WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                processdialog.show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                processdialog.dismiss()
            }
        }

        // Enable JavaScript
        binding.webviewWiki.settings.javaScriptEnabled = true
        // Load a website
        binding.webviewWiki.loadUrl("https://bn.wikipedia.org/wiki/"+bname)

    }

    override fun onBackPressed() {
        if(binding.webviewWiki.canGoBack())
        {
            binding.webviewWiki.goBack()
        }
        else
        super.onBackPressed()
    }



}