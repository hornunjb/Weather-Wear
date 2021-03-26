package edu.uc.hornunjb.weatherwear.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.uc.hornunjb.weatherwear.repo.Repository

class MainViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}