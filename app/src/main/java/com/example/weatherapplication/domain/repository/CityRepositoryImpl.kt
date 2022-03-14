package com.example.weatherapplication.domain.repository

import com.example.weatherapplication.data.datasource.network.CityDataSource
import com.example.weatherapplication.data.model.CityResponse
import com.example.weatherapplication.util.Resource
import retrofit2.Response

const val API = "245ee60863f0e320995f8dedb437005a"

class CityRepositoryImpl(
    private val cityDataSource: CityDataSource
) : CityRepository {

    override suspend fun requestCityWeather(lat: Double, lon: Double): Resource<CityResponse> {
        return responseToResource(cityDataSource.getCity(lat,lon,API))
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