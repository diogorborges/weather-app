package com.diogo.weather.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import com.diogo.core.model.Parent
import com.diogo.core.model.WeatherResponse
import com.diogo.resources.ui.livedata.observeForeverTo
import com.diogo.weather.data.WeatherRepository
import com.diogo.weather.domain.WeatherUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class HomeViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private val dispatcher = TestCoroutineDispatcher()

    private lateinit var weatherUseCase: WeatherUseCase

    private lateinit var homeViewModel: HomeViewModel

    @MockK
    private lateinit var weatherRepository: WeatherRepository

    private val stateActions = mutableListOf<HomeUIState>()

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        Dispatchers.setMain(dispatcher)

        weatherUseCase = WeatherUseCase(weatherRepository)
        homeViewModel = HomeViewModel(weatherUseCase)

        homeViewModel.homeUiState.asLiveData().observeForeverTo(stateActions)
    }

    @Test
    fun `test initial loading state`() = runTest {
        homeViewModel.loadWeather()

        assert(stateActions[0] == HomeUIState.Loading)
    }

    @Test
    fun `test error state`() = runTest {
        coEvery {
            weatherUseCase.execute("")
        } returns WeatherUseCase.Response.Error("")

        homeViewModel.loadWeather()

        assert(stateActions[0] == HomeUIState.Loading)
        assert(stateActions[1] == HomeUIState.Error)
    }

    @Test
    fun `test success state`() = runTest {
        val mockResponse =
            WeatherResponse(mutableListOf(), "title", Parent("title"), "timezone", Date())

        coEvery {
            weatherRepository.loadWeather("")
        } returns mockResponse

        coEvery {
            weatherUseCase.execute("")
        } returns WeatherUseCase.Response.Success(mockResponse)

        homeViewModel.loadWeather()

        assert(stateActions[0] == HomeUIState.Loading)
        assert(stateActions[1] == HomeUIState.Success(mockResponse))
    }

}