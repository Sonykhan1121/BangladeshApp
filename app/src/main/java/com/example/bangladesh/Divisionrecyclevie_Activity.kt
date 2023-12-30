package com.example.bangladesh


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bangladesh.databinding.ActivityDivisionrecyclevieBinding
import java.io.InputStreamReader

class Divisionrecyclevie_Activity : AppCompatActivity() {
    private lateinit var divisionAdapter: DivisionAdapter
    private lateinit var districtAdapter: DistrictAdapter
    private lateinit var historicalPlaceAdapter: HistoricalPlaceAdapter
    private lateinit var binding: ActivityDivisionrecyclevieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDivisionrecyclevieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the intent
        val intent = intent
        binding.titleRvId.setText(intent.getStringExtra("title"))
        // Check if the intent contains the extra data
        if (intent.hasExtra("jsonFile")) {
            // Retrieve the JSON file resource ID from the intent
            val jsonFileResourceId = intent.getIntExtra("jsonFile", 0)

            // Load the JSON file based on the resource ID
            loadJsonFile(jsonFileResourceId)
        }
        else{
            Log.d("MyApp","intent data not comming")

        }
    }

    private fun loadJsonFile(jsonFileResourceId: Int) {
        val inputStream = resources.openRawResource(jsonFileResourceId)
        val jsonString = InputStreamReader(inputStream).use { it.readText() }
        //debug
        Log.d("MyApp", "JSON String: $jsonString")

        // Determine the type of JSON data and parse it accordingly
        when (jsonFileResourceId) {
            R.raw.divisions -> {
                val divisionList = DivisionItem.parseJson(jsonString)
                setupRecyclerView(divisionList)
            }
            R.raw.districts -> {
                val districtList = DistrictItem.parseJson(jsonString)
                setupRecyclerView(districtList)
            }
            R.raw.historicalplaces -> {
                val historicalPlaceList = HistoricalPlaceItem.parseJson(jsonString)
                setupRecyclerView(historicalPlaceList)
            }
            else -> {
                Log.e("jsonId", "Unexpected resource ID: $jsonFileResourceId")
            }
            // Add more cases for other JSON files if needed
        }
    }

    private fun setupRecyclerView(dataList: List<Any>?) {
        // Log the value of dataList
        Log.d("MyApp", "DataList: $dataList")

        // Check if dataList is not null before using firstOrNull
        if (dataList != null) {
            // Set up RecyclerView based on the data type
            when (dataList.firstOrNull()) {
                is DivisionItem -> {
                    divisionAdapter = DivisionAdapter(dataList as List<DivisionItem>)
                    setRecyclerViewAdapter(divisionAdapter)
                }
                is DistrictItem -> {
                    districtAdapter = DistrictAdapter(dataList as List<DistrictItem>)
                    setRecyclerViewAdapter(districtAdapter)
                }
                is HistoricalPlaceItem -> {
                    historicalPlaceAdapter =
                        HistoricalPlaceAdapter(dataList as List<HistoricalPlaceItem>)
                    setRecyclerViewAdapter(historicalPlaceAdapter)
                }
                else -> {
                    Log.e("MyApp", "Unexpected data type in DataList")
                }
            }
        } else {
            Log.e("MyApp", "DataList is null")
        }
    }



    private fun setRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
        binding.recyclerViewDv.apply {
            layoutManager = LinearLayoutManager(this@Divisionrecyclevie_Activity)
            this.adapter = adapter
        }
    }
}
