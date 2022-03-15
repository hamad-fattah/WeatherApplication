package com.example.weatherapplication.presentation.di

import android.app.Application
import com.example.weatherapplication.domain.usecase.AllSavedCityUseCase
import com.example.weatherapplication.domain.usecase.CityUseCase
import com.example.weatherapplication.domain.usecase.SavingCityUseCase
import com.example.weatherapplication.presentation.viewmodel.CityViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun provideCityViewModelFactory(
        application: Application,
        cityUseCase: CityUseCase,
        savingCityUseCase: SavingCityUseCase,
        allSavedCityUseCase: AllSavedCityUseCase
    ) : CityViewModelFactory{
        return CityViewModelFactory(
            application,
            cityUseCase,
            savingCityUseCase,
            allSavedCityUseCase
        )
    }
}