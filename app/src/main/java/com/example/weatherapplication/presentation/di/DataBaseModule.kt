package com.example.weatherapplication.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.weatherapplication.data.db.CityDao
import com.example.weatherapplication.data.db.CityDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideCityDataBase(app:Application): CityDatabase{
        return Room.databaseBuilder(app,CityDatabase::class.java,"city_db")
            .fallbackToDestructiveMigration()
            .build()
    }
    @Singleton
    @Provides
    fun provideCityDao(cityDatabase: CityDatabase): CityDao{
        return cityDatabase.getCityDAO()
    }

}