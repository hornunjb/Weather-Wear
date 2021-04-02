package edu.uc.hornunjb.weatherwear.dao
import edu.uc.hornunjb.weatherwear.dto.WeatherResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IWeatherDAO {

    @GET("weather?")
    fun getCurrentWeatherData(@Query("lat") lat: String, @Query("lon") lon: String, @Query("APPID") app_id: String): WeatherResponse

    @GET("weather?")
    suspend fun getCityWeatherData(@Query("q") cityName:String, @Query("appid") app_id: String): WeatherResponse
}