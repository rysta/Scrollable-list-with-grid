package com.example.scrollablelistwithgrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameResourceId: Int,
    val courseId: Int,
    @DrawableRes val imageResourceId: Int
)
