package com.diogo.core.service

import com.diogo.core.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{locationId}.json")
    suspend fun loadWeather(@Path("locationId") locationId: String): WeatherResponse
}