package edu.uc.hornunjb.weatherwear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.uc.hornunjb.weatherwear.repo.Repository
import edu.uc.hornunjb.weatherwear.ui.main.MainFragment
import edu.uc.hornunjb.weatherwear.ui.main.MainViewModel
import edu.uc.hornunjb.weatherwear.ui.main.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    private var weatherData: TextView? = null
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
/*        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }*/

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()

        viewModel.myResponse.observe(this, Observer { response ->
            Log.d("Response", response.name)
            Log.d("Response", response.sys.toString())
            Log.d("Response", response.weather.toString())
            Log.d("Response", response.wind.toString())
            Log.d("Response", response.coord.toString())
            Log.d("Response", response.main.toString())
        })

       /* NOTE: Here I was trying to display the weather data under the actual temp value, but
          the way the MainFragment is setup with the ViewModel and  MainActivity makes this a bit more confusing.
          It throws a null pointer reference error and the app will crash */

       //weatherData = findViewById(R.id.lblActualTempValue)
       //findViewById<View>(R.id.btnRecommendations).setOnClickListener{getCurrentData()}

    }

    /*internal fun getCurrentData() {
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

                    val stringBuilder = "Country: " +
                            weatherResponse.sys!!.country +
                            "\n" +
                            "Temperature: " +
                            weatherResponse.main!!.temp +
                            "\n" +
                            "Temperature(Min): " +
                            weatherResponse.main!!.temp_min +
                            "\n" +
                            "Temperature(Max): " +
                            weatherResponse.main!!.temp_max +
                            "\n" +
                            "Humidity: " +
                            weatherResponse.main!!.humidity +
                            "\n" +
                            "Pressure: " +
                            weatherResponse.main!!.pressure

                    weatherData!!.text = stringBuilder
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherData!!.text = t.message
            }
        })
    }*/

    // Cincinnati weather data with my API key
   /* companion object {
        var BaseUrl = "http://api.openweathermap.org/"
        var AppId = "2513864aca32eeb68b96cb812043b641"
        var lat = "39"
        var lon = "85"
    }*/

}