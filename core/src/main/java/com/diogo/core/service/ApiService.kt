package com.diogo.core.service

import com.diogo.core.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("{locationId}")
    suspend fun loadWeather(@Query("locationId") locationId: String): WeatherResponse
}