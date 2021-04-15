package edu.uc.hornunjb.weatherwear.ui.main

import android.os.Bundle
import androidx.lifecycle.*
import edu.uc.hornunjb.weatherwear.R
import edu.uc.hornunjb.weatherwear.dto.WeatherResponse
import edu.uc.hornunjb.weatherwear.repo.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<WeatherResponse> = MutableLiveData()

    fun getPost(CityName:String) {
        viewModelScope.launch {
            val response: WeatherResponse = repository.getPost(CityName)
            myResponse.value = response
        }
    }



}