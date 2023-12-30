package com.example.bangladesh

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bangladesh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bdMapId.setOnClickListener {
            // Handle the click event for the Map button if needed
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
