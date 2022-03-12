package com.example.weatherapplication.domain.repository

import com.example.weatherapplication.data.model.CityResponse
import com.example.weatherapplication.util.Resource

interface CityRepository {
    suspend fun getCity(lat:Double,lon:Double,appid:String): Resource<CityResponse>
}