package com.example.moviescompose.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BottomNavigationItem(
    val route: String,
    @StringRes val name: Int,
    @DrawableRes val icon: Int
)
