package com.example.moviescompose.features.movieDetails.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.moviescompose.R
import com.example.moviescompose.features.movieDetails.presentation.content.MovieDetailsNormalConnection
import com.example.moviescompose.ui.components.BackAppBar
import com.example.moviescompose.ui.components.ScreenWithErrorConnection

@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    Scaffold(topBar = {
        BackAppBar(
            title = stringResource(R.string.movie_details),
            backAction = { navController.popBackStack() }
        )
    }) {
        MovieDetailsScreenContent(viewModel)
    }
}

@Composable
private fun MovieDetailsScreenContent(viewModel: MovieDetailsViewModel) {
    val state = viewModel.state.value
    if (state.error.isNotBlank()) {
        ScreenWithErrorConnection(retryButtonClick = {
            viewModel.getMovieDetails()
        })
    } else {
        val screenHeight = LocalConfiguration.current.screenHeightDp.dp
        val movieDetails = state.movieDetails
        Column(modifier = Modifier.fillMaxSize()) {
            if (state.isLoading) {
                MovieDetailsShimmerContent()
            } else {
                movieDetails?.let {
                    MovieDetailsNormalConnection(
                        screenHeight = screenHeight,
                        favoriteClick = { movieDetails ->
                            viewModel.favoriteClick(movieDetails)
                        },
                        movieDetails = it
                    )
                }
            }
        }
    }
}

@Composable
fun MovieDetailsShimmerContent() {

}
