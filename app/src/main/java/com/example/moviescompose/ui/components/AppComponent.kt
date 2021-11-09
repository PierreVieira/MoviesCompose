package com.example.moviescompose.ui.components

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.example.moviescompose.R
import com.example.moviescompose.navigation.BottomNavigationItem
import com.example.moviescompose.navigation.NavigationComponent
import com.example.moviescompose.navigation.Route
import com.example.moviescompose.navigation.VisibilityBottomNavigationListener
import com.example.moviescompose.ui.theme.MoviesComposeTheme

@ExperimentalMaterialApi
@Composable
fun AppComponent() {
    MoviesComposeTheme {
        var visibleBottomNavigationBar by remember {
            mutableStateOf(false)
        }
        val navController = rememberNavController()
        Surface(color = MaterialTheme.colors.background) {
            Scaffold(
                bottomBar = {
                    if (visibleBottomNavigationBar) {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavigationItem(
                                    name = R.string.home,
                                    route = Route.Home.value,
                                    icon = R.drawable.ic_home
                                ),
                                BottomNavigationItem(
                                    name = R.string.favorites,
                                    route = Route.Favorites.value,
                                    icon = R.drawable.ic_star
                                ),
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                }
            ) {
                NavigationComponent(
                    navController = navController,
                    visibilityBottomNavigationListener = object :
                        VisibilityBottomNavigationListener {
                        override fun show() {
                            visibleBottomNavigationBar = true
                        }

                        override fun hide() {
                            visibleBottomNavigationBar = false
                        }
                    }
                )
            }
        }
    }
}
