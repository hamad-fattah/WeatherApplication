package com.example.weatherapplication.data.datasource.network

import com.example.weatherapplication.data.api.CityService
import com.example.weatherapplication.data.model.CityResponse
import retrofit2.Response

class CityDataSourceImpl(
    private val cityService : CityService
) : CityDataSource {
    override suspend fun getCity(lat: Double, lon: Double, appid: String): Response<CityResponse> {
        return cityService.getCity(lat, lon, appid)
    }
}