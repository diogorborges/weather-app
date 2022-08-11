package com.diogo.weather.data

import com.diogo.core.model.WeatherResponse
import com.diogo.core.service.ApiService

class WeatherRepositoryImpl(
    private val apiService: ApiService
) : WeatherRepository {

    override suspend fun loadWeather(locationId: String): WeatherResponse =
        apiService.loadWeather(locationId)
}