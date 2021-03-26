package edu.uc.hornunjb.weatherwear.Service

import edu.uc.hornunjb.weatherwear.dao.IWeatherDAO
import edu.uc.hornunjb.weatherwear.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: IWeatherDAO by lazy {
        retrofit.create(IWeatherDAO::class.java)
    }
}