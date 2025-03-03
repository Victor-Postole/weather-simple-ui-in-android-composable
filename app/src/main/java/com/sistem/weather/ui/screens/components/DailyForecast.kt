package com.sistem.weather.ui.screens.components

import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import com.sistem.weather.R
import com.sistem.weather.ui.theme.ColorGradient1
import com.sistem.weather.ui.theme.ColorGradient2
import com.sistem.weather.ui.theme.ColorGradient3
import com.sistem.weather.ui.theme.ColorTextSecondary
import com.sistem.weather.ui.theme.ColorTextSecondaryVariant
import com.sistem.weather.ui.theme.ColorWindForecast


@OptIn(ExperimentalMotionApi::class)
@Preview
@Composable
fun DailyForecast(
    modifier: Modifier = Modifier,
    forecast: String = "Rain showers",
    date: String = "Monday, 12 Feb"
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ){

        val (forecastImage, forecastValue, forecastInfo, windImage,col, title, description, background) = createRefs()

        CardBackground(
            modifier = Modifier.constrainAs(background){
                linkTo(
                    start = parent.start,
                    end = parent.end,
                    top = parent.top,
                    bottom = parent.bottom,
                    topMargin = 24.dp
                )
                height = Dimension.fillToConstraints
            }
        )

        var progress by remember { mutableStateOf(0f) }

        MotionLayout(
            start = ConstraintSet {
                val forecastImage = createRefFor("forecastImage")
                constrain(forecastImage) {
                    start.linkTo(parent.start, margin = 0.dp)
                    top.linkTo(parent.top)
                }
            },
            end = ConstraintSet {
                val forecastImage = createRefFor("forecastImage")
                constrain(forecastImage) {
                    start.linkTo(parent.start, margin = 15.dp)
                    top.linkTo(parent.top)


            progress = progress,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_sub_rain),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .height(175.dp)
                    .layoutId("forecastImage")
            )
        }

        LaunchedEffect(Unit) {
            animate(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = tween(2000)
            ) { value, _ -> progress = value }
        }

        Column( modifier = Modifier.constrainAs(col){
            start.linkTo(anchor = parent.start, margin = 25.dp)
            bottom.linkTo(anchor = background.bottom, margin = 5.dp)
        }){
            Text(
                text = forecast,
                style = MaterialTheme.typography.titleLarge,
                color = ColorTextSecondary,
                fontWeight =  FontWeight.Medium,

            )

            Text(
                text = date ,
                style = MaterialTheme.typography.bodyMedium,
                color = ColorTextSecondaryVariant
            )
        }

        Text(
            text = "15",
                style = TextStyle(  brush = Brush.linearGradient(
                    0f to Color.White,
                    1f to Color.White.copy(alpha = 0.3f)
                )
            ),
            color = ColorTextSecondary,
            fontWeight =  FontWeight.Medium,
            fontSize = 100.sp,

            modifier = Modifier.constrainAs(forecastValue){
                end.linkTo(anchor = parent.end, margin = 25.dp)
                top.linkTo(anchor = forecastImage.top, margin = 20.dp)
            }
        )

        Text(
            text = "Feels like 13",
            color = ColorTextSecondary,
            fontWeight =  FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier.constrainAs(forecastInfo){
                end.linkTo(anchor = parent.end, margin = 25.dp)
                top.linkTo(anchor = forecastValue.bottom)
            }
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.constrainAs(windImage){
                end.linkTo(anchor = parent.end, margin = 25.dp)
                top.linkTo(anchor = forecastInfo.bottom, margin = 10.dp)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_wind),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp),
                tint = ColorWindForecast
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_frosty),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp),
                tint = ColorWindForecast
            )
        }

    }
}

@Composable
 fun CardBackground( modifier : Modifier = Modifier){
    Box(modifier = modifier
        .fillMaxWidth()
        .background(
            brush = Brush.linearGradient(
                0f to ColorGradient1,
                0.25f to ColorGradient2,
                1f to ColorGradient3
            ),
            shape = RoundedCornerShape(32.dp)
        )
    )
}