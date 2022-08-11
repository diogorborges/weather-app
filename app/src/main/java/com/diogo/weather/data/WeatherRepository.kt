package com.diogo.weather.data

import com.diogo.core.model.WeatherResponse

interface WeatherRepository {
    suspend fun loadWeather(locationId: String): WeatherResponse?
}