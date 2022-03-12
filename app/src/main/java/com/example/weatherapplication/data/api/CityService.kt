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
        appid:String = "245ee60863f0e320995f8dedb437005a"
    ) : Response<CityResponse>
}