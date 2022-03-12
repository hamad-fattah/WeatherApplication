package com.example.weatherapplication.data

import com.example.weatherapplication.data.model.CityResponse
import retrofit2.Response

interface CityDataSource {
    suspend fun getCity(
                        lat:Double,
                        lon:Double,
                        appid:String):Response<CityResponse>
}