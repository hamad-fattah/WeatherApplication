package com.example.weatherapplication.presentation.di

import com.example.weatherapplication.data.CityDataSource
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

    ): CityRepository {
        return CityRepositoryImpl(
            cityDataSource
        )
    }
}