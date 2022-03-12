package com.example.weatherapplication.domain.usecase

import com.example.weatherapplication.data.model.CityResponse
import com.example.weatherapplication.domain.repository.CityRepository
import com.example.weatherapplication.util.Resource

class GetCityUseCase(
    private val cityRepository: CityRepository
) {
    suspend fun execute(lat: Double, lon: Double, appid: String):Resource<CityResponse>{
        return cityRepository.getCity(lat,lon,appid)
    }
}