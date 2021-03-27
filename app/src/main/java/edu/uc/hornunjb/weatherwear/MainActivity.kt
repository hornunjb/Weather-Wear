package edu.uc.hornunjb.weatherwear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.uc.hornunjb.weatherwear.repo.Repository
import edu.uc.hornunjb.weatherwear.ui.main.MainViewModel
import edu.uc.hornunjb.weatherwear.ui.main.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_data_fragment)

        Toast.makeText(this, "How's the Weather?", Toast.LENGTH_SHORT).show()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()

        viewModel.myResponse.observe(this, Observer { response ->
            // This is for Console Logging to Check the GSON response.
            Log.d("Response", response.name)
            Log.d("Response", response.sys.toString())
            Log.d("Response", response.weather.toString())
            Log.d("Response", response.wind.toString())
            Log.d("Response", response.coord.toString())
            Log.d("Response", response.main.toString())

            //Testing Results and building GSON into legible strings.
            val stringBuilder = "City Name: " + response.name + "\n" + "Temperature: " + response.main.temp + "\n" + "Pressure: " + response.main.pressure + "\n" + "Humidity: " + response.main.humidity + "%" + "\n" + "Wind Speed: " + response.wind.speed + "\n" + "Clouds: " + response.weather

        })

       /* NOTE: Here I was trying to display the weather data under the actual temp value, but
          the way the MainFragment is setup with the ViewModel and  MainActivity makes this a bit more confusing.
          It throws a null pointer reference error and the app will crash */

       //weatherData = findViewById(R.id.lblActualTempValue)
       //findViewById<View>(R.id.btnRecommendations).setOnClickListener{getCurrentData()}

    }

}