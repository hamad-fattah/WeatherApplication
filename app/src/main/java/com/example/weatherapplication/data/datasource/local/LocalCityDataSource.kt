package com.example.weatherapplication.data.datasource.local

import com.example.weatherapplication.data.model.CityResponse
import kotlinx.coroutines.flow.Flow

interface LocalCityDataSource {
    suspend fun saveCityToDB(city : CityResponse)
    fun getSavedCities(): Flow<List<CityResponse>>
}