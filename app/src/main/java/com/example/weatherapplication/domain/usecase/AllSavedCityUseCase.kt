package com.example.weatherapplication.domain.usecase

import com.example.weatherapplication.data.model.CityResponse
import com.example.weatherapplication.domain.repository.CityRepository
import kotlinx.coroutines.flow.Flow

class AllSavedCityUseCase(private val cityRepository: CityRepository) {
    fun execute(): Flow<List<CityResponse>> {
        return cityRepository.getSavedCities()
    }
}