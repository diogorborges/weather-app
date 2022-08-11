package com.diogo.weather.domain

import com.diogo.core.model.WeatherResponse
import com.diogo.weather.data.WeatherRepository

class WeatherUseCase(
    private val weatherRepository: WeatherRepository
) {
    suspend fun execute(locationId: String): Response =
        try {
            val response = weatherRepository.loadWeather(locationId)
            Response.Success(response)
        } catch (throwable: Throwable) {
            Response.Error(throwable.message)
        }

    sealed class Response {
        data class Success(val weatherResponse: WeatherResponse?) : Response()
        data class Error(val message: String?) : Response()
    }
}