package com.example.weatherapplication.domain.usecase

import com.example.weatherapplication.data.model.CityResponse
import com.example.weatherapplication.domain.repository.CityRepository

class SavingCityUseCase(private val cityRepository: CityRepository) {
    suspend fun execute(city: CityResponse) = cityRepository.saveCity(city)
}