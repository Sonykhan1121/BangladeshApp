package com.example.bangladesh
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class DivisionItem(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("bn_name") val bnName: String,
    @SerializedName("lat") val lat: Float,
    @SerializedName("long") val long: Float,
    @SerializedName("picture") val picture: String
) {
    companion object {
        fun parseJson(jsonString: String): List<DivisionItem> {
            val gson = Gson()
            val result = gson.fromJson(jsonString, DivisionList::class.java)
            return result.divisions
        }
    }
}

data class DivisionList(@SerializedName("divisions") val divisions: List<DivisionItem>)
