package com.example.moviescompose.features.movieDetails.presentation.components.info.components

import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails

@Composable
fun FavoriteSection(movieDetails: MovieDetails, favoriteClick: (MovieDetails) -> Unit) {

}

@Composable
private fun FavoriteIcon(movieDetails: MovieDetails, favoriteClick: (MovieDetails) -> Unit) {
    IconButton(onClick = { favoriteClick(movieDetails) }) {

    }
}