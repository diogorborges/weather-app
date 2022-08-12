package com.diogo.weather.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.diogo.core.BuildConfig
import com.diogo.core.model.ConsolidatedWeather
import com.diogo.core.model.WeatherResponse
import com.diogo.resources.R
import com.diogo.resources.databinding.FragmentHomeBinding
import com.diogo.resources.ui.fragment.InjectionFragment
import com.diogo.resources.utils.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.kodein.di.generic.instance

class HomeFragment : InjectionFragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by instance()
    private lateinit var viewBinding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = FragmentHomeBinding.bind(view)
        viewModel.loadWeather()
        observeStates()
    }

    private fun observeStates() {
        viewModel.homeUiState.onEach { state ->
            when (state) {
                is HomeUIState.Success -> {
                    with(viewBinding) {
                        homeSuccess.root.show()
                        homeError.root.gone()
                        homeEmpty.root.gone()
                        loading.gone()
                    }
                    with(state.weather) {
                        val currentWeather =
                            consolidatedWeather.find { it.date.toCalendar.isSameDay(state.weather.time.toCalendar) }
                        displayCurrentDate(this, currentWeather)
                    }
                }
                is HomeUIState.Error -> {
                    with(viewBinding) {
                        homeError.root.show()
                        homeSuccess.root.gone()
                        homeEmpty.root.gone()
                        loading.gone()
                    }
                }
                HomeUIState.Loading -> {
                    viewBinding.loading.show()
                }
                HomeUIState.Empty -> {
                    with(viewBinding) {
                        homeEmpty.root.show()
                        homeSuccess.root.gone()
                        homeError.root.gone()
                        loading.gone()
                    }
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun displayCurrentDate(
        weather: WeatherResponse,
        consolidatedWeather: ConsolidatedWeather?
    ) {
        with(viewBinding.homeSuccess) {
            cityName.text = weather.title
            countryName.text = weather.parent.title
            time.text = weather.time.toCalendar.getDisplayDate()
            timezone.text = weather.timezone
            consolidatedWeather?.let {
                temperature.text = it.theTemp.getCelsius(requireContext())
                weatherState.text = it.weatherStateName
                lowerTemperature.text = it.minTemp.getCelsius(requireContext())
                higherTemperature.text = it.maxTemp.getCelsius(requireContext())
                Glide.with(this@HomeFragment)
                    .load("${BuildConfig.BASE_API_URL}icons/${it.weatherStateAbbr}.png")
                    .into(weatherImage)
            }
        }
    }

}