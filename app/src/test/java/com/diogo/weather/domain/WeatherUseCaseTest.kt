package com.diogo.weather.domain

import com.diogo.core.model.Parent
import com.diogo.core.model.WeatherResponse
import com.diogo.weather.data.WeatherRepository
import com.diogo.weather.domain.WeatherUseCase.*
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class WeatherUseCaseTest {

    @MockK
    private lateinit var weatherRepository: WeatherRepository

    private lateinit var weatherUseCase: WeatherUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        weatherUseCase = WeatherUseCase(weatherRepository)
    }

    @Test
    fun `test load weather`() {
        val mockResponse =
            WeatherResponse(mutableListOf(), "title", Parent("title"),"timezone", Date())

        coEvery {
            weatherRepository.loadWeather("")
        } returns mockResponse

        val response = runBlocking {
            weatherUseCase.execute("")
        }

        assert(Response.Success(mockResponse) == response)
    }

}