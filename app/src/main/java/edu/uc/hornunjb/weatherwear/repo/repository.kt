package edu.uc.hornunjb.weatherwear.repo

import edu.uc.hornunjb.weatherwear.Service.RetrofitInstance
import edu.uc.hornunjb.weatherwear.dto.WeatherResponse
import edu.uc.hornunjb.weatherwear.utils.Constants
import retrofit2.Call

class Repository {
    suspend fun getPost() : WeatherResponse {
        return RetrofitInstance.api.getCityWeatherData(Constants.CITY, Constants.APP_ID)
    }
}