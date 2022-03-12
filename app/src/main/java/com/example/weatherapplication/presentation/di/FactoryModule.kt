package com.example.weatherapplication.presentation.di

import android.app.Application
import com.example.weatherapplication.domain.usecase.GetCityUseCase
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
        getCityUseCase: GetCityUseCase
    ) : CityViewModelFactory{
        return CityViewModelFactory(
            application,
            getCityUseCase
        )
    }
}