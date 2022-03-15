package com.example.weatherapplication.data.model

import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("sunrise")
    val sunrise: Int,
    @SerializedName("sunset")
    val sunset: Int
)