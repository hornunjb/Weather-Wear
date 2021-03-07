package edu.uc.hornunjb.weatherwear.dto

import com.google.gson.annotations.SerializedName
import java.util.ArrayList



class Weather {
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("main")
    var main: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("icon")
    var icon: String? = null
}










