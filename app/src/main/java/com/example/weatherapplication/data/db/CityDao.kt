package com.example.weatherapplication.data.db

import androidx.room.*
import com.example.weatherapplication.data.model.CityResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(city:CityResponse)

    @Query("SELECT * FROM cities")
    fun getAllCities(): Flow<List<CityResponse>>
}