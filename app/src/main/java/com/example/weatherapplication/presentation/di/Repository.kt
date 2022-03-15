package com.example.weatherapplication.presentation.di

import com.example.weatherapplication.data.datasource.local.LocalCityDataSource
import com.example.weatherapplication.data.datasource.network.CityDataSource
import com.example.weatherapplication.domain.repository.CityRepository
import com.example.weatherapplication.domain.repository.CityRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Repository {
    @Singleton
    @Provides
    fun provideCityRepository(
        cityDataSource: CityDataSource,
        localCityDataSource: LocalCityDataSource

        ): CityRepository {
        return CityRepositoryImpl(
            cityDataSource,
            localCityDataSource
        )
    }
}