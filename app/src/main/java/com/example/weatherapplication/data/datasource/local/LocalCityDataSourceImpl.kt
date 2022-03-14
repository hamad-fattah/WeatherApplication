package com.example.weatherapplication.data.datasource.local

import com.example.weatherapplication.data.db.CityDao
import com.example.weatherapplication.data.model.CityResponse
import kotlinx.coroutines.flow.Flow

class LocalCityDataSourceImpl(
    private val cityDao: CityDao
) : LocalCityDataSource {
    override suspend fun saveCityToDB(city: CityResponse) {
        cityDao.insert(city)
    }

    override fun getSavedCities(): Flow<List<CityResponse>> {
        return cityDao.getAllCities()
    }

}