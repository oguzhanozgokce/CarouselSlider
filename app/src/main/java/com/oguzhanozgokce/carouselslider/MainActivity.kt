package com.oguzhanozgokce.carouselslider

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oguzhanozgokce.carouselslider.ui.items
import com.oguzhanozgokce.carouselslider.ui.theme.CarouselSliderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarouselSliderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CarouselComponent(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselComponent(modifier: Modifier = Modifier) {
    val carouselState = rememberCarouselState { items.count() }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Carousel - HorizontalMultiBrowseCarousel",
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Start)
        )
        HorizontalMultiBrowseCarousel(
            state = carouselState,
            modifier = Modifier
                .width(412.dp)
                .height(221.dp),
            preferredItemWidth = 186.dp,
            itemSpacing = 8.dp,
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) { i ->
            val item = items[i]

            val itemDescription = stringResource(id = item.contentDescriptionResId)
            Image(
                modifier = Modifier
                    .height(205.dp)
                    .maskClip(MaterialTheme.shapes.extraLarge)
                    .maskBorder(
                        BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
                        MaterialTheme.shapes.extraLarge
                    ),
                painter = painterResource(id = item.imageResId),
                contentDescription = itemDescription,
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = "Carousel - HorizontalUncontainedCarousel", modifier = Modifier
                .align(Alignment.Start).padding(16.dp)
        )
        HorizontalUncontainedCarousel(
            state = rememberCarouselState { items.count() },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 16.dp, bottom = 16.dp),
            itemWidth = 186.dp,
            itemSpacing = 8.dp,
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) { i ->
            val item = items[i]
            Image(
                modifier = Modifier
                    .height(205.dp)
                    .maskClip(MaterialTheme.shapes.extraLarge)
                    .maskBorder(
                        BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
                        MaterialTheme.shapes.extraLarge
                    ),
                painter = painterResource(id = item.imageResId),
                contentDescription = stringResource(id = item.contentDescriptionResId),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CarouselSliderTheme {
        CarouselComponent()
    }
}