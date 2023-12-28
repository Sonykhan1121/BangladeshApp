package com.example.bangladesh

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.InputStreamReader

class Divisionrecyclevie_Activity : AppCompatActivity() {
    private lateinit var divisionAdapter: DivisionAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_divisionrecyclevie)


        val inputStream = resources.openRawResource(R.raw.divisions)
        val jsonString = InputStreamReader(inputStream).use { it.readText() }

        // Parse JSON data into a list of DivisionItem objects
        val divisionList = DivisionItem.parseJson(jsonString)

        // Set up RecyclerView
        divisionAdapter = DivisionAdapter(divisionList)
        findViewById<RecyclerView>(R.id.recyclerView_dv).apply {
            layoutManager = LinearLayoutManager(this@Divisionrecyclevie_Activity)
            adapter = divisionAdapter
        }
    }
}