package com.example.weatherapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ViewModel.WeatherViewModel
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.weatherapp.R


@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {

    var searchCity by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.aurinko),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sää Sovellus", style = MaterialTheme.typography.headlineMedium)
            TextField(
                value = searchCity,
                onValueChange = { uusiTeksti ->
                    searchCity = uusiTeksti
                },
                label = { Text("Syötä kaupunki") }
            )

            Button(
                onClick = {
                    viewModel.fetchWeather(searchCity)
                    searchCity = ""
                }
            ) {
                Text("Hae sää")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = viewModel.weatherInfo, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

