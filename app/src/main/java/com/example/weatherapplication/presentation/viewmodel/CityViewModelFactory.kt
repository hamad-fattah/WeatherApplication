package com.example.weatherapplication.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapplication.domain.usecase.CityUseCase

class CityViewModelFactory(
     val app : Application,
     val cityUseCase: CityUseCase
):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return CityViewModel(
           app,
           cityUseCase
       ) as T
    }
}