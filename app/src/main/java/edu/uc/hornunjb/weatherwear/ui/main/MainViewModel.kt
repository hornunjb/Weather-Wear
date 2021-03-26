package edu.uc.hornunjb.weatherwear.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uc.hornunjb.weatherwear.dto.WeatherResponse
import edu.uc.hornunjb.weatherwear.repo.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<WeatherResponse> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response: WeatherResponse = repository.getPost()
            myResponse.value = response
        }
    }
}