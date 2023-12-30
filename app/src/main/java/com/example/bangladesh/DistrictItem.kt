package com.example.bangladesh

import android.util.Log
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class DistrictItem(
    @SerializedName("id") val id: Int,
    @SerializedName("division_id") val divisionId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("bn_name") val bnName: String,
    @SerializedName("lat") val lat: Float,
    @SerializedName("long") val long: Float
){
    companion object {
        fun parseJson(jsonString: String): List<DistrictItem> {
            return try {
                val gson = Gson()
                val result = gson.fromJson(jsonString, DistrictList::class.java)
                result.districts
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("CVRT", "not covert to class")
                emptyList() // Return an empty list in case of parsing failure

            }

        }
    }
}

data class DistrictList(@SerializedName("districts") val districts: List<DistrictItem>)
