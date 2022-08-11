package com.diogo.weather.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.diogo.core.model.ConsolidatedWeather
import com.diogo.core.model.WeatherResponse
import com.diogo.resources.databinding.FragmentHomeBinding
import com.diogo.resources.ui.fragment.InjectionFragment
import org.kodein.di.generic.instance
import com.diogo.resources.R
import com.diogo.resources.utils.gone
import com.diogo.resources.utils.show
import kotlinx.android.synthetic.main.view_home_success.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeFragment : InjectionFragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by instance()
    private lateinit var viewBinding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = FragmentHomeBinding.bind(view)

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
                            consolidatedWeather.find { it.date == state.weather.time }
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
        currentWeather: ConsolidatedWeather?
    ) {
        with(viewBinding) {
            cityName.text = weather.title
            countryName.text = weather.parent.title
            time.text = weather.time
            timezone.text = weather.timezone
            currentWeather?.let {
                temperature.text = it.theTemp.toString()
                weatherState.text = it.weatherStateName
                lowerTemperature.text = it.minTemp.toString()
                higherTemperature.text = it.maxTemp.toString()
            }
        }
    }

}