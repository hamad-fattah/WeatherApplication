package com.example.weatherapplication.domain.repository

import com.example.weatherapplication.data.CityDataSource
import com.example.weatherapplication.data.model.CityResponse
import com.example.weatherapplication.util.Resource
import retrofit2.Response

class CityRepositoryImpl(
    private val cityDataSource: CityDataSource
) : CityRepository {
    override suspend fun getCity(lat: Double, lon: Double, appid: String): Resource<CityResponse> {
        return responseToResource(cityDataSource.getCity(lat,lon,appid))
    }


    private fun responseToResource(response:Response<CityResponse>): Resource<CityResponse> {
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}