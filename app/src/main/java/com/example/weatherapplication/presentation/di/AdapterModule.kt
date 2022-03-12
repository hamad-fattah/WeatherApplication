package com.example.weatherapplication.presentation.di

import com.example.weatherapplication.presentation.adapter.CityAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    @Singleton
    @Provides
    fun provideCityAdapter(): CityAdapter {
        return CityAdapter()
    }
}