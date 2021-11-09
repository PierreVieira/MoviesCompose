package com.example.moviescompose.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.moviescompose.R
import com.example.moviescompose.features.favorites.presentation.FavoritesScreen
import com.example.moviescompose.features.home.presentation.HomeScreen
import com.example.moviescompose.features.movieDetails.presentation.MovieDetailsScreen
import com.example.moviescompose.util.RoutesParams

@ExperimentalMaterialApi
@Composable
fun NavigationComponent(
    navController: NavHostController,
    visibilityBottomNavigationListener: VisibilityBottomNavigationListener
) {
    NavHost(navController = navController, startDestination = Route.Home.value) {
        composable(route = Route.Home.value) {
            HomeScreen(
                navController = navController,
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.bottom_navigation_height))
            )
            visibilityBottomNavigationListener.show()
        }
        composable(
            route = Route.Details.value,
            arguments = listOf(navArgument(RoutesParams.MOVIE_ID) { type = NavType.IntType })
        ) {
            MovieDetailsScreen(navController = navController)
            visibilityBottomNavigationListener.hide()
        }
        composable(route = Route.Favorites.value) {
            FavoritesScreen(navController = navController)
            visibilityBottomNavigationListener.show()
        }
    }
}