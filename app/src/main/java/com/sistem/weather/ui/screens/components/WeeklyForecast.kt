import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.isSelected
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sistem.weather.R
import com.sistem.weather.ui.theme.ColorGradient1
import com.sistem.weather.ui.theme.ColorGradient2
import com.sistem.weather.ui.theme.ColorGradient3
import com.sistem.weather.ui.theme.ColorImageShadow
import com.sistem.weather.ui.theme.Pink80
import kotlin.time.Duration.Companion.days


val weeklyForecast: List<WeeklyForecast>
    get() = listOf(
        WeeklyForecast(
            day = "Sun",
            date = "02 Mar",
            imageId = R.drawable.img_sub_rain,
            maxTemperature = "28°",
            temperature = "26°",
            colorBackground =  Pink80,
            true
        ),
        WeeklyForecast(
            day = "Mon",
            date = "03 Mar",
            imageId = R.drawable.img_sun,
            maxTemperature = "1°",
            temperature = "-1°",
            colorBackground =  ColorGradient2
        ),
        WeeklyForecast(
            day = "Tue",
            date = "04 Mar",
            imageId = R.drawable.img_moon_stars,
            maxTemperature = "1°",
            temperature = "-1°",
            colorBackground =  Pink80
        ),
        WeeklyForecast(
            day = "Wed",
            date = "05 Mar",
            imageId = R.drawable.img_sun,
            maxTemperature = "1°",
            temperature = "-1°",
            colorBackground =  Pink80
        ),
        WeeklyForecast(
            day = "Thu",
            date = "06 Mar",
            imageId = R.drawable.img_thunder,
            maxTemperature = "1°",
            temperature = "-1°",
            colorBackground =  ColorImageShadow
        ),
        WeeklyForecast(
            day = "Fri",
            date = "07 Mar",
            imageId = R.drawable.img_rain,
            maxTemperature = "1°",
            temperature = "-1°",
            colorBackground =  Pink80
        ),
        WeeklyForecast(
            day = "Sat",
            date = "08 Mar",
            imageId = R.drawable.img_moon_stars,
            maxTemperature = "1°",
            temperature = "-1°",
            colorBackground =  ColorImageShadow
        ),
        WeeklyForecast(
            day = "Sun",
            date = "09 Mar",
            imageId = R.drawable.img_sun,
            maxTemperature = "1°",
            temperature = "-1°",
            colorBackground =  ColorImageShadow
        )


    )

@Preview
@Composable
fun WeeklyForecast(
    modifier: Modifier = Modifier
) {
    var selectedIndex by remember { mutableIntStateOf(-1) }

    Column(modifier = modifier.padding(10.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth().height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Weekly forecast",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Next month",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Blue,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Color.Blue
            )
        }

        LazyRow(
            modifier = Modifier.padding(top = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(weeklyForecast.size) { index ->
                WeeklyForecastItem(
                    item = weeklyForecast[index],
                    isSelected = index == selectedIndex,
                    onClick = { selectedIndex = index }
                )
            }
        }
    }
}

@Composable
fun WeeklyForecastItem(
    item: WeeklyForecast,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val updateModifier = remember(isSelected){
        if (isSelected){
            modifier.background(
                brush = Brush.linearGradient(
                    0f to ColorGradient1,
                    0.25f to ColorGradient2,
                    1f to ColorGradient3
                ),
                shape = RoundedCornerShape(30.dp)
            )
        }else {
            modifier.background(
                color = Color.White,
                shape = RoundedCornerShape(30.dp)
            )
        }
    }

    val isSelectedColor = remember(isSelected){
        if(isSelected){
            Color.White
        }else{
            Color.Gray
        }
    }

    val isSelectedTempreture = remember(isSelected){
        if(isSelected){
            TextStyle(  brush = Brush.verticalGradient(
                0f to Color.White,
                1f to Color.White.copy(alpha = 0.3f)
            ))
        }else{
            TextStyle(  brush = Brush.verticalGradient(
                0f to Color.Black,
                1f to Color.Black.copy(alpha = 0.3f)
            ))
        }
    }

    Column(
        modifier = updateModifier.width(60.dp).clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = modifier.fillMaxWidth().padding(10.dp),
            text = item.day,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = modifier.fillMaxWidth(),
            text = item.date,
            fontSize = 12.sp,
            color = isSelectedColor,
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(id = item.imageId),
            contentDescription = null,
            modifier = Modifier.padding(vertical = 10.dp).size(40.dp)
        )

        Text(
            modifier = modifier.padding(5.dp),
            text = item.maxTemperature,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            style = isSelectedTempreture
        )

        Box(
            modifier = modifier.padding(vertical = 10.dp)
                .background(
                    color = item.colorBackground,
                    shape = RoundedCornerShape(30.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                modifier = modifier.padding(5.dp),
                text = item.temperature,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }


    }
}


data class WeeklyForecast(
    val day: String,
    val date: String,
    val imageId: Int,
    val maxTemperature: String,
    val temperature: String,
    val colorBackground: Color,
    val isSelected: Boolean = false
)