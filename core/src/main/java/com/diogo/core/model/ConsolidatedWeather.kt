package com.diogo.core.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ConsolidatedWeather(
    val id: Long,
    @SerializedName("weather_state_name")
    val weatherStateName: String,
    @SerializedName("weather_state_abbr")
    val weatherStateAbbr: String,
    @SerializedName("min_temp")
    val minTemp: Double,
    @SerializedName("max_temp")
    val maxTemp: Double,
    @SerializedName("the_temp")
    val theTemp: Double,
    @SerializedName("applicable_date")
    val date: Date
)
