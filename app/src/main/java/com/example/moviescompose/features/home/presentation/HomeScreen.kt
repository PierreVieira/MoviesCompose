package com.example.moviescompose.features.home.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.moviescompose.features.home.domain.model.Movie
import com.example.moviescompose.features.home.presentation.components.HomeAppBar
import com.example.moviescompose.ui.components.SectionTitle
import com.example.moviescompose.features.home.presentation.components.movieCard.MovieCard
import com.example.moviescompose.features.home.presentation.states.MoviesListState
import com.example.moviescompose.ui.components.ScreenWithErrorConnection

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = { HomeAppBar() }
    ) {
        HomeContent(navController, viewModel)
    }
}

@ExperimentalMaterialApi
@Composable
private fun HomeContent(
    navController: NavController,
    viewModel: HomeViewModel,
) {
    val sections = viewModel.getSections()
    if (sections[0].state.error.isBlank()) {
        LazyColumn(
            modifier = Modifier.padding(start = 16.dp),
        ) {
            items(sections) { section ->
                VerticalSpacer()
                SectionTitle(textId = section.textId)
                VerticalSpacer(height = 8.dp)
                MoviesRowContainer(state = section.state, navController = navController)
            }
            item {
                VerticalSpacer()
            }
        }
    } else {
        ScreenWithErrorConnection(
            retryButtonClick = {
                viewModel.getAllMovies()
            }
        )
    }
}

@ExperimentalMaterialApi
@Composable
private fun MoviesRowContainer(state: MoviesListState, navController: NavController) {
    if (state.isLoading) {
        LoadingMoviesListRow()
    } else {
        MoviesListRow(state.movies, navController)
    }
}

@ExperimentalMaterialApi
@Composable
fun LoadingMoviesListRow() {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        repeat(10) {
            item {
                MovieCard(
                    movie = null,
                    onClick = {}
                )
                HorizontalSpacer()
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MoviesListRow(movies: List<Movie>, navController: NavController) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(movies) { movie ->
            MovieCard(movie = movie, onClick = {})
            HorizontalSpacer()
        }
    }
}


@Composable
private fun VerticalSpacer(height: Dp = 16.dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
private fun HorizontalSpacer(width: Dp = 16.dp) {
    Spacer(modifier = Modifier.width(width))
}
