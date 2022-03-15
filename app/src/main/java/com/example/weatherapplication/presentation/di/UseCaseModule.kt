package com.example.weatherapplication.presentation.di

import com.example.weatherapplication.domain.repository.CityRepository
import com.example.weatherapplication.domain.usecase.AllSavedCityUseCase
import com.example.weatherapplication.domain.usecase.CityUseCase
import com.example.weatherapplication.domain.usecase.SavingCityUseCase
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
    ): CityUseCase {
        return CityUseCase(cityRepository)
    }
    @Singleton
    @Provides
    fun provideSavingCityUseCase(
        cityRepository: CityRepository
    ):SavingCityUseCase{
        return SavingCityUseCase(cityRepository)
    }
    @Singleton
    @Provides
    fun provideAllSavedCityUseCase(
        cityRepository: CityRepository
    ):AllSavedCityUseCase{
        return AllSavedCityUseCase(cityRepository)
    }

}