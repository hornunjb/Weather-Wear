package edu.uc.hornunjb.weatherwear

import edu.uc.hornunjb.weatherwear.dto.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Unit Test for the WeatherResponse object
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class WeatherResponseUnitTest {
    @Test
    fun confirmSunny_outputsSpaghetti() {
        var weatherResponse = WeatherResponse(Coord(), ArrayList<Weather>(), Main(), Wind(), Sys(), "Cincinnati")
        var weatherObject = Weather()
        weatherObject.description = "sunny"
        weatherResponse.weather.add(weatherObject)

        assertEquals("It is sunny in Cincinnati", weatherResponse.toString())
    }
}