package com.example.weatherapplication.data.api

import com.example.weatherapplication.data.model.CityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CityService {
    @GET("weather")
    suspend fun getCity(
        @Query("lat")
        lat:Double,
        @Query("lon")
        lon:Double,
        @Query("appid")
        appid:String = "c6e381d8c7ff98f0fee43775817cf6ad"
    ) : Response<CityResponse>
}