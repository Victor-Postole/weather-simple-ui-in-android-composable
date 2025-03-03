package com.sistem.weather.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sistem.weather.R
import com.sistem.weather.ui.theme.ColorGradient1
import com.sistem.weather.ui.theme.ColorGradient2
import com.sistem.weather.ui.theme.ColorGradient3
import com.sistem.weather.ui.theme.ColorImageShadow
import com.sistem.weather.ui.theme.ColorSurface
import com.sistem.weather.ui.theme.ColorTextPrimary
import com.sistem.weather.ui.theme.ColorTextPrimaryVariant
import com.sistem.weather.ui.theme.ColorTextSecondaryVariant

@Preview
@Composable
fun ActionBar(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        ControlButton()

        LocationInfo(modifier = Modifier.padding(top = 20.dp))

        ProfileButton()
    }
}

@Composable fun ControlButton(
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier
            .size(48.dp)
            .customShadow(
                color = Color.Black,
                alpha = 0.5f,
                blurRadius = 10.dp,
                shadowRadius = 12.dp,
                borderRadius = 48.dp,
            ),
        color = ColorSurface,
        shape = CircleShape
    ){
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_control),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
private fun ProfileButton(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .size(48.dp)

            .border(
                width = 1.dp,
                color = ColorSurface,
                shape = CircleShape
            )
            .customShadow(
                color = ColorImageShadow,
                alpha = 0.7f,
                blurRadius = 10.dp,
                shadowRadius = 12.dp,
                borderRadius = 48.dp,
                offsetY = 6.dp
            )
    ){
        Image(
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}

@Composable
fun LocationInfo(
    modifier: Modifier = Modifier,
    location: String = "Rome"
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.spacedBy(8.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_location_pin),
                contentDescription = null,
                modifier = Modifier
                    .height(18.dp),
                contentScale = ContentScale.FillHeight
            )

            Text(
                text = location,
                style = MaterialTheme.typography.titleLarge,
                color = ColorTextPrimary,
                fontWeight = FontWeight.Bold
            )
        }

        ProgressBar()
    }
}

@Composable
private fun ProgressBar(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier

            .background(
                brush = Brush.linearGradient(
                    0f to ColorGradient1,
                    0.25f to ColorGradient2,
                    1f to ColorGradient3
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                vertical = 2.dp,
                horizontal = 10.dp
            )
    ){
        Text(
            text = "Loading...",
            style = MaterialTheme.typography.labelSmall,
            color = ColorTextSecondaryVariant
        )
    }
}

fun Modifier.customShadow(
    color: Color,
    alpha: Float = 0.15f,
    blurRadius: Dp = 10.dp, // Increase for a stronger blur
    borderRadius: Dp = 8.dp,
    offsetY: Dp = 4.dp,
    shadowRadius: Dp
): Modifier = this.drawBehind {
    val shadowColor = color.copy(alpha = alpha)
    val paint = Paint().apply { this.color = shadowColor }
    paint.asFrameworkPaint().setShadowLayer(blurRadius.toPx(), 0f, offsetY.toPx(), shadowColor.toArgb())

    drawIntoCanvas { canvas ->
        canvas.drawRoundRect(
            left = 0f,
            top = 0f,
            right = size.width,
            bottom = size.height,
            radiusX = borderRadius.toPx(),
            radiusY = borderRadius.toPx(),
            paint = paint
        )
    }
}
