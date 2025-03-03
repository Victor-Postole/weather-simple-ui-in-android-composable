package com.sistem.weather.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sistem.weather.R
import com.sistem.weather.ui.theme.ColorGradient1
import com.sistem.weather.ui.theme.ColorGradient2
import com.sistem.weather.ui.theme.ColorGradient3
import com.sistem.weather.ui.theme.ColorTextSecondaryVariant

@Preview
@Composable
fun AirQaulity(
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier.fillMaxWidth()
           .background(
            color = Color.White,
            shape = RoundedCornerShape(20.dp)
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Row(
            modifier = modifier.padding(10.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_air_quality_header),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = modifier.padding(end = 7.dp).size(40.dp),
                colorFilter = ColorFilter.tint(Color.Blue)
            )

            Text(
                text = "Air quality",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,
            )

            Spacer(modifier = modifier.weight(1f))

            Box(
                modifier = modifier
                    .padding(10.dp)
                    .customShadow(
                        color = Color.Black,
                        alpha = 0.2f,
                        blurRadius = 15.dp,
                        shadowRadius = 12.dp,
                        borderRadius = 48.dp,
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(32.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = modifier.padding(1.dp),
                    painter = painterResource(id = R.drawable.ic_refresh),
                    contentDescription = null,
                )
            }
        }

        Row(
            modifier = modifier.padding(10.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            AirQualityItem(modifier = modifier, statusWeather = "Good", tempretureWeather = "12", R.drawable.ic_real_feel)
            AirQualityItem(modifier = modifier, statusWeather = "Good", tempretureWeather = "Clouds", R.drawable.ic_wind_qality)
            AirQualityItem(modifier = modifier, statusWeather = "Good", tempretureWeather = "66%", R.drawable.ic_so2)
        }

        Row(
            modifier = modifier.padding(10.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            AirQualityItem(modifier = modifier, statusWeather = "Good", tempretureWeather = "88%", R.drawable.ic_frosty)
            AirQualityItem(modifier = modifier, statusWeather = "Good", tempretureWeather = "12", R.drawable.ic_wind)
            AirQualityItem(modifier = modifier, statusWeather = "Good", tempretureWeather = "12", R.drawable.ic_o3)
        }


    }
}

@Composable
fun AirQualityItem(
    modifier: Modifier,
    statusWeather: String,
    tempretureWeather: String,
    imageStatus: Int
){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Image(
            painter = painterResource(id = imageStatus),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .size(30.dp),
            colorFilter = ColorFilter.tint(Color.Blue)
        )

        Column (
            modifier = modifier.padding(5.dp)
        ){
            Text(
                text = statusWeather,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )

            Text(
                text = tempretureWeather,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}