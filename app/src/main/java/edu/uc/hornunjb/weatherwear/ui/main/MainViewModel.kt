package edu.uc.hornunjb.weatherwear.ui.main

import android.os.Bundle
import androidx.lifecycle.*
import edu.uc.hornunjb.weatherwear.R
import edu.uc.hornunjb.weatherwear.dto.WeatherResponse
import edu.uc.hornunjb.weatherwear.repo.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<WeatherResponse> = MutableLiveData()

    /*
      Calls the getWeather method from the repository class
     */
    fun getWeather() {
        viewModelScope.launch {
            val response: WeatherResponse = repository.getWeather()
            myResponse.value = response
        }
    }



}