package edu.uc.hornunjb.weatherwear.repo

import edu.uc.hornunjb.weatherwear.Service.RetrofitInstance
import edu.uc.hornunjb.weatherwear.dto.WeatherResponse
import edu.uc.hornunjb.weatherwear.utils.Constants
import retrofit2.Call

class Repository {
    /*
     This returns the weather of the location found in the constants class
     @return a weather response object for the call
     */
    suspend fun getWeather() : WeatherResponse {
        return RetrofitInstance.api.getCityWeatherData(Constants.CITY, Constants.APP_ID)
    }
}