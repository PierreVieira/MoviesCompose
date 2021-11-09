package com.example.moviescompose.navigation

import com.example.moviescompose.util.RoutesParams

sealed class Route(val value: String) {
    object Home: Route(RoutesParams.HOME_BASE_ROUTE)
    object Details: Route("${RoutesParams.DETAILS_BASE_ROUTE}{${RoutesParams.MOVIE_ID}}") {
        fun getDynamicRoute(movieId: Int) =  "${RoutesParams.DETAILS_BASE_ROUTE}${movieId}"
    }
    object Favorites: Route(RoutesParams.FAVORITES_BASE_ROUTE)
}
