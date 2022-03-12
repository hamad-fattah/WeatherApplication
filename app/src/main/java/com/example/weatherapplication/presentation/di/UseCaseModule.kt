package com.example.weatherapplication.presentation.di

import com.example.weatherapplication.domain.repository.CityRepository
import com.example.weatherapplication.domain.usecase.GetCityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetNewsheadLinesUseCase(
        cityRepository: CityRepository
    ): GetCityUseCase {
        return GetCityUseCase(cityRepository)
    }
}