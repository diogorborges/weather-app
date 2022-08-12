package com.diogo.weather.presentation

import com.diogo.core.model.WeatherResponse

sealed class HomeUIState {
    data class Success(val weather: WeatherResponse) : HomeUIState()
    object Error : HomeUIState()
    object Loading : HomeUIState()
    object Empty : HomeUIState()
}