package com.example.moviescompose.navigation

sealed class Route(val value: String) {
    object Home: Route("home")
}
