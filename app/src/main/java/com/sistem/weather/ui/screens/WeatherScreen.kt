package com.sistem.weather.ui.screens

import WeeklyForecast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import com.sistem.weather.ui.screens.components.ActionBar
import com.sistem.weather.ui.screens.components.AirQaulity
import com.sistem.weather.ui.screens.components.DailyForecast
import com.sistem.weather.ui.theme.ColorBackground



@Composable
fun WeatherScreen(){
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        containerColor = ColorBackground
    ){ paddings ->

        Column(
            modifier = Modifier.padding(paddings)
                .fillMaxSize()
                .padding(
                    horizontal = 24.dp,
                    vertical = 10.dp
                )
                .verticalScroll(rememberScrollState())
        ) {
            ActionBar()

            Spacer(modifier = Modifier.height(10.dp))

            DailyForecast()

            Spacer(modifier = Modifier.height(15.dp))

            AirQaulity()

            Spacer(modifier = Modifier.height(15.dp))

            WeeklyForecast()
        }

    }
}