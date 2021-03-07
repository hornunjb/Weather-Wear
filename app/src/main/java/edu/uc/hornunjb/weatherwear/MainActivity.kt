package edu.uc.hornunjb.weatherwear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View

import edu.uc.hornunjb.weatherwear.dao.IWeatherDAO
import edu.uc.hornunjb.weatherwear.ui.main.MainFragment
import edu.uc.hornunjb.weatherwear.dto.WeatherResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private var weatherData: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()

        }

    }

    internal fun getCurrentData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(IWeatherDAO::class.java)
        val call = service.getCurrentWeatherData(lat, lon, AppId)
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!
                    weatherData!!.text = weatherResponse.toString()
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherData!!.text = t.message
            }
        })
    }

    // Cincinnati weather data with my API key
    companion object {
        var BaseUrl = "http://api.openweathermap.org/"
        var AppId = "2513864aca32eeb68b96cb812043b641"
        var lat = "39"
        var lon = "85"
    }
}