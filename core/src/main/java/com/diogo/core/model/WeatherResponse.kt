package com.diogo.core.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class WeatherResponse(
    @SerializedName("consolidated_weather")
    val consolidatedWeather: MutableList<ConsolidatedWeather>,
    val title: String,
    val parent: Parent,
    val timezone: String,
    val time: Date
): Serializable

