package com.example.weatherapplication.data.db

import androidx.room.TypeConverter
import com.example.weatherapplication.data.model.*
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromClouds(clouds: Clouds): String? {
        return Gson().toJson(clouds)
    }
    @TypeConverter
    fun toClouds(string :String):Clouds{
        return Gson().fromJson(string,Clouds::class.java)
    }

    @TypeConverter
    fun FromCoord(coord: Coord):String?{
        return Gson().toJson(coord)
    }
    @TypeConverter
    fun toCoord(string :String):Coord{
        return Gson().fromJson(string,Coord::class.java)
    }
    @TypeConverter
    fun fromMain(main: Main):String?{
        return Gson().toJson(main)
    }
    @TypeConverter
    fun toMain(string :String):Main{
        return Gson().fromJson(string,Main::class.java)
    }
    @TypeConverter
    fun fromSys(sys: Sys):String?{
        return Gson().toJson(sys)
    }
    @TypeConverter
    fun toSys(string :String):Sys{
        return Gson().fromJson(string,Sys::class.java)
    }
    @TypeConverter
    fun fromWeather(weather: List<Weather>):String?{
        return Gson().toJson(weather)
    }
    @TypeConverter
    fun toWeather(string :String):List<Weather>{
        return listOf(Gson().fromJson(string,Weather::class.java))
    }
    @TypeConverter
    fun fromWind(wind: Wind):String?{
        return Gson().toJson(wind)
    }
    @TypeConverter
    fun toWind(string :String):Wind{
        return Gson().fromJson(string,Wind::class.java)
    }

}