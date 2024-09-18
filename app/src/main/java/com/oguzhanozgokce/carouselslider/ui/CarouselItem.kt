package com.oguzhanozgokce.carouselslider.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.oguzhanozgokce.carouselslider.R

data class CarouselItem(
    val id: Int,
    @DrawableRes val imageResId: Int,
    @StringRes val contentDescriptionResId: Int
)

val items = listOf(
    CarouselItem(0, R.drawable.carousel_image_1, R.string.carousel_image_1_description),
    CarouselItem(1, R.drawable.carousel_image_2, R.string.carousel_image_2_description),
    CarouselItem(2, R.drawable.carousel_image_3, R.string.carousel_image_3_description),
    CarouselItem(3, R.drawable.carousel_image_4, R.string.carousel_image_4_description),
    CarouselItem(4, R.drawable.carousel_image_5, R.string.carousel_image_5_description),
    CarouselItem(5, R.drawable.carousel_image_6, R.string.carousel_image_6_description),
)
