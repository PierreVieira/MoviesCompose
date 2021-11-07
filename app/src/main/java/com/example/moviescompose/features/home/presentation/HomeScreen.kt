package com.example.moviescompose.features.home.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
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
import com.example.moviescompose.features.home.presentation.components.SectionHomeTitle
import com.example.moviescompose.features.home.presentation.components.movieCard.MovieCard
import com.example.moviescompose.features.home.presentation.states.MoviesListState

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
    LazyColumn(
        modifier = Modifier.padding(start = 16.dp),
    ) {
        items(sections) { section ->
            VerticalSpacer()
            SectionHomeTitle(textId = section.textId)
            VerticalSpacer(height = 8.dp)
            MoviesRowContainer(state = section.state, navController = navController)
        }
        item {
            VerticalSpacer()
        }
    }
}

@Composable
private fun VerticalSpacer(height: Dp = 16.dp) {
    Spacer(modifier = Modifier.height(height))
}

@ExperimentalMaterialApi
@Composable
private fun MoviesRowContainer(state: MoviesListState, navController: NavController) {
    when {
        state.isLoading -> CircularProgressIndicator()
        state.error.isNotBlank() -> {
        }
        else -> MoviesListRow(state.movies, navController)
    }
}

@ExperimentalMaterialApi
@Composable
fun MoviesListRow(movies: List<Movie>, navController: NavController) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(movies) { movie ->
            MovieCard(movie = movie, onClick = {})
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}
