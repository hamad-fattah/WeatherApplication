package com.example.weatherapplication.domain.usecase

import com.example.weatherapplication.data.model.CityResponse
import com.example.weatherapplication.domain.repository.CityRepository
import com.example.weatherapplication.util.Resource

class CityUseCase(
    private val cityRepository: CityRepository
) {
    suspend fun requestCityWeather(lat: Double, lon: Double):Resource<CityResponse>{
        return cityRepository.requestCityWeather(lat, lon)
    }
}