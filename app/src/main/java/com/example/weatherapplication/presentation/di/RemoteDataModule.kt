package com.example.weatherapplication.presentation.di

import com.example.weatherapplication.data.CityDataSource
import com.example.weatherapplication.data.CityDataSourceImpl
import com.example.weatherapplication.data.api.CityService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideCityRemoteDataSource(
        cityAPIService: CityService
    ):CityDataSource{
        return CityDataSourceImpl(cityAPIService)
    }

}