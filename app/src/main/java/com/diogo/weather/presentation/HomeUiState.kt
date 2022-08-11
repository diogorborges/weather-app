package com.diogo.weather.presentation

import com.diogo.core.model.WeatherResponse

sealed class HomeUIState {
    data class Success(val weather: WeatherResponse) : HomeUIState()
    data class Error(val message: String?) : HomeUIState()
    object Loading : HomeUIState()
    object Empty : HomeUIState()
}