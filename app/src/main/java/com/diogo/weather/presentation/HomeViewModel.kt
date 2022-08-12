package com.diogo.weather.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diogo.weather.domain.WeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val weatherUseCase: WeatherUseCase
) : ViewModel() {

    private val _homeUiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
    val homeUiState: StateFlow<HomeUIState> = _homeUiState

    fun loadWeather() {
        viewModelScope.launch {
            _homeUiState.value = HomeUIState.Loading
            when (val response = weatherUseCase.execute(LOCATION_ID)) {
                is WeatherUseCase.Response.Success -> {
                    response.weatherResponse?.let {
                        _homeUiState.value = HomeUIState.Success(it)
                    } ?: run {
                        _homeUiState.value = HomeUIState.Empty
                    }
                }
                is WeatherUseCase.Response.Error -> {
                    _homeUiState.value = HomeUIState.Error
                }
            }
        }
    }

    companion object {
        const val LOCATION_ID = "4418"
    }

}