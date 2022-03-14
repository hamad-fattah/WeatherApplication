package com.example.weatherapplication.domain.repository

import com.example.weatherapplication.data.model.CityResponse
import com.example.weatherapplication.util.Resource
import kotlinx.coroutines.flow.Flow

interface CityRepository {
    suspend fun requestCityWeather(lat: Double, lon: Double): Resource<CityResponse>
    suspend fun saveCity(city:CityResponse)
    fun getSavedCities(): Flow<List<CityResponse>>
}