package com.diogo.weather.di

import com.diogo.weather.data.WeatherRepository
import com.diogo.weather.data.WeatherRepositoryImpl
import com.diogo.weather.domain.WeatherUseCase
import com.diogo.weather.presentation.HomeViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

internal const val MODULE_NAME = "App"

val appModule = Kodein.Module(MODULE_NAME) {
    bind() from singleton { HomeViewModel(instance()) }

    bind() from singleton { WeatherUseCase(instance()) }

    bind<WeatherRepository>() with singleton { WeatherRepositoryImpl(instance()) }
}