package edu.uc.hornunjb.weatherwear.dto

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class WeatherResponse (
    @SerializedName("coord")
    var coord: Coord? = null,
    @SerializedName("sys")
var sys: Sys? = null,
    @SerializedName("weather")
var weather: ArrayList<Weather> = ArrayList<Weather>(),
    @SerializedName("main")
var main: Main? = null,
    @SerializedName("wind")
var wind: Wind? = null,
    @SerializedName("rain")
var rain: Rain? = null,
    @SerializedName("clouds")
var clouds: Clouds? = null,
    @SerializedName("dt")
var dt: Float = 0.toFloat(),
    @SerializedName("id")
var id: Int = 0,
    @SerializedName("name")
var name: String? = null,
    @SerializedName("cod")
var cod: Float = 0.toFloat()
)