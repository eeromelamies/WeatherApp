package com.example.weatherapp.ViewModel

import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.remote.RetrofitInstance
import kotlinx.coroutines.launch


class WeatherViewModel : ViewModel() {

    var weatherInfo by mutableStateOf("Haetaan säätietoja...")
        private set

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getWeather(
                    city = city,
                    apiKey = BuildConfig.OPENWEATHER_API_KEY
                )
                val temp = response.main.temp
                val cityName = response.name
                weatherInfo = "Kaupunki: $cityName\nLämpötila: $temp °C"
            } catch (e: Exception) {
                weatherInfo = "Virhe: ${e.localizedMessage}"
            }
        }
    }
}