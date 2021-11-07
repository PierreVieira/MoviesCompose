package com.example.moviescompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviescompose.features.home.presentation.HomeScreen

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Route.Home.value) {
        composable(route = Route.Home.value) {
            HomeScreen()
        }
    }
}