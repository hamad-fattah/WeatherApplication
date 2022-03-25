package com.example.weatherapplication.domain.repository

import com.example.weatherapplication.data.datasource.local.LocalCityDataSource
import com.example.weatherapplication.data.datasource.network.CityDataSource
import com.example.weatherapplication.data.model.CityResponse
import com.example.weatherapplication.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

const val API = "c6e381d8c7ff98f0fee43775817cf6ad"

class CityRepositoryImpl(
    private val cityDataSource: CityDataSource,
    private val localCityDataSource: LocalCityDataSource
) : CityRepository {

    override suspend fun requestCityWeather(lat: Double, lon: Double): Resource<CityResponse> {
        return responseToResource(cityDataSource.getCity(lat,lon,API))
    }

    override suspend fun saveCity(city: CityResponse) {
        localCityDataSource.saveCityToDB(city)
    }

    override fun getSavedCities(): Flow<List<CityResponse>> {
        return localCityDataSource.getSavedCities()
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