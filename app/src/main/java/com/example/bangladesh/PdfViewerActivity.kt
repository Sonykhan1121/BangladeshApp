package com.example.bangladesh

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.barteksc.pdfviewer.PDFView
import com.example.bangladesh.databinding.ActivityPdfViewerBinding
import java.io.File

class PdfViewerActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPdfViewerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfViewerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val loadingDialog = createLoadingDialog()
        loadingDialog.show()
        binding.pdfView.fromAsset("bangladesh.pdf")
            .enableSwipe(true)
            .swipeHorizontal(false)
            .onError { t ->
                // Handle error (e.g., log it or display a message)
                Log.e("PdfViewer", "Error loading PDF: ${t.message}")
                loadingDialog.dismiss()
            }
            .onLoad{
                loadingDialog.dismiss()
            }
            .load()


    }

    private fun createLoadingDialog(): ProgressDialog {
        val  progressDialog =  ProgressDialog(this)
        progressDialog.setMessage("Loading PDF...")
        progressDialog.setCancelable(false)
        return progressDialog
    }
}