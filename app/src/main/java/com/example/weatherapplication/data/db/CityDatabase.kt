package com.example.weatherapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherapplication.data.model.CityResponse

@Database(
    entities = [CityResponse::class],
    version = 1,
    exportSchema = false
)
abstract class CityDatabase:RoomDatabase() {
    abstract fun getCityDAO():CityDao
}