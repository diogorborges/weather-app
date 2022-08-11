package com.diogo.core.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherResponse(
    val consolidatedWeather: MutableList<ConsolidatedWeather>,
    val title: String,
    val parent: Parent,
    @SerializedName("timezone_name")
    val timeZoneName: String,
    val timezone: String,
    val time: String
): Serializable

