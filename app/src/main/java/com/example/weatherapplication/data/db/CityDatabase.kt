package com.example.weatherapplication.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weatherapplication.data.model.CityResponse

@Database(
    entities = [CityResponse::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class CityDatabase:RoomDatabase() {
    abstract fun getCityDAO():CityDao

    companion object{
        @Volatile
        private var instance:CityDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
            context.applicationContext,
                CityDatabase::class.java,
                "city_db.db"
            ).build()
    }
}