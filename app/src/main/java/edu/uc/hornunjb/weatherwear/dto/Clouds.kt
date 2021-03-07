package edu.uc.hornunjb.weatherwear.dto

import com.google.gson.annotations.SerializedName

class Clouds (
    @SerializedName("all")
    var all: Float = 0.toFloat()
)