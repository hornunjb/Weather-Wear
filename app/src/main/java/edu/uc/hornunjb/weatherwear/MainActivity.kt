package edu.uc.hornunjb.weatherwear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.uc.hornunjb.weatherwear.repo.Repository
import edu.uc.hornunjb.weatherwear.ui.main.MainViewModel
import edu.uc.hornunjb.weatherwear.ui.main.MainViewModelFactory
import kotlinx.android.synthetic.main.weather_data_fragment.*
import kotlin.math.round


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_data_fragment)

        //Creating TextView Objects to bind to our fragment
        var temperatureText: TextView
        var cityText: TextView
        var countryText: TextView
        var humidityText: TextView
        var pressureText: TextView
        var conditionsText: TextView
        var windText: TextView

        Toast.makeText(this, "How's the Weather?", Toast.LENGTH_SHORT).show()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getWeather()

        viewModel.myResponse.observe(this, Observer { response ->

            //Building Individual Objects for binding and Parsing
            //val country = response.sys.country
            val city = response.name
            val humidity = response.main.humidity.toString() + "%"
            val pressure = response.main.pressure
            val tempRange = round((response.main.temp_min -273)*9/5 + 32).toString() + " to " + round((response.main.temp_max -273)*9/5 + 32).toString() + " Degrees"
            Toast.makeText(this, tempRange, Toast.LENGTH_LONG).show()
            val wind = response.wind.speed.toString() + " mph"
            val otherConditions = response.weather[0].main.toString() + " - " +  response.weather[0].description.toString() + "\n" + "Humidity: " + humidity + "       " + "Pressure: " + pressure + " units" + "\n" + "Wind: " + wind

            //Finding Fragment Labels by Id and setting them to our response
            cityText = findViewById(R.id.lblLocationPlaceholder)
            cityText.text = city
            conditionsText = findViewById(R.id.lblConditionsPlaceholder)
            conditionsText.text = otherConditions
            temperatureText=findViewById(R.id.lblTempPlaceholder)
            temperatureText.text = tempRange

        })

    }

}