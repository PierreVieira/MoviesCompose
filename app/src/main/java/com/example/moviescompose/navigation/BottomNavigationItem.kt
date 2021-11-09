package com.example.moviescompose.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.lang.reflect.Modifier

data class BottomNavigationItem(
    val route: String,
    @StringRes val name: Int,
    @DrawableRes val icon: Int
)
