package com.example.bangladesh

import android.app.ProgressDialog
import android.content.Intent
import android.content.res.AssetFileDescriptor
import android.graphics.pdf.PdfRenderer
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.bangladesh.databinding.ActivityMainBinding
import com.example.bangladesh.databinding.ActivityPdfViewerBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var binding1: ActivityPdfViewerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bdMapId.setOnClickListener {
            val intent = Intent(this,PdfViewerActivity::class.java)
            startActivity(intent)
        }

        binding.divisionId.setOnClickListener {
            // Start the Divisionrecyclevie_Activity with the corresponding JSON file
            startDivisionActivity()
        }

        binding.districtsId.setOnClickListener {
            // Start the Divisionrecyclevie_Activity with the corresponding JSON file
            startDistrictsActivity()
        }

        binding.historyId.setOnClickListener {
            // Start the Divisionrecyclevie_Activity with the corresponding JSON file
            startHistoricalPlacesActivity()
        }
    }

     fun startDivisionActivity() {
        val intent = Intent(this, Divisionrecyclevie_Activity::class.java)
        intent.putExtra("jsonFile", R.raw.divisions)
         intent.putExtra("title","বাংলাদেশের ৭টি বিভাগের নাম")
        startActivity(intent)

    }

     fun startDistrictsActivity() {
        val intent = Intent(this, Divisionrecyclevie_Activity::class.java)
        intent.putExtra("jsonFile", R.raw.districts)
         intent.putExtra("title","বাংলাদেশের ৬৪টি জেলার নাম")

        startActivity(intent)

    }

     fun startHistoricalPlacesActivity() {
        val intent = Intent(this, Divisionrecyclevie_Activity::class.java)
        intent.putExtra("jsonFile", R.raw.historicalplaces)
         intent.putExtra("title","বাংলাদেশের ঐতিহাসিক স্থানের নাম")

        startActivity(intent)

    }



}