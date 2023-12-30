package com.example.bangladesh

import android.util.Log
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class HistoricalPlaceItem(
    @SerializedName("name") val name: String,
    @SerializedName("place") val place: String,
    @SerializedName("picture") val picture :String

){
    companion object {
        fun parseJson(jsonString: String): List<HistoricalPlaceItem> {
            return try {
                val gson = Gson()
                val result = gson.fromJson(jsonString, HistoricalList::class.java)
                result.historical_places
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("CVRT", "not covert to class history")
                emptyList() // Return an empty list in case of parsing failure

            }
        }
    }
}

data class HistoricalList(@SerializedName("historical_places") val historical_places: List<HistoricalPlaceItem>)

