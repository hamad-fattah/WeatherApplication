package com.example.weatherapplication.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapplication.domain.usecase.AllSavedCityUseCase
import com.example.weatherapplication.domain.usecase.CityUseCase
import com.example.weatherapplication.domain.usecase.SavingCityUseCase

class CityViewModelFactory(
     val app : Application,
     val cityUseCase: CityUseCase,
     val savingCityUseCase: SavingCityUseCase,
     val allSavedCityUseCase: AllSavedCityUseCase

):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return CityViewModel(
           app,
           cityUseCase,
           savingCityUseCase,
           allSavedCityUseCase
       ) as T
    }
}