package com.example.weatherapplication.presentation.di

import com.example.weatherapplication.data.datasource.local.LocalCityDataSource
import com.example.weatherapplication.data.datasource.local.LocalCityDataSourceImpl
import com.example.weatherapplication.data.db.CityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(cityDao: CityDao) : LocalCityDataSource{
        return LocalCityDataSourceImpl(cityDao)
    }
}