package com.example.weatherapplication.presentation.di

import android.app.Application
import com.example.weatherapplication.domain.usecase.CityUseCase
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
        cityUseCase: CityUseCase
    ) : CityViewModelFactory{
        return CityViewModelFactory(
            application,
            cityUseCase
        )
    }
}