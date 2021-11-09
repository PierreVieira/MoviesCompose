package com.example.moviescompose.features.favorites.presentation

import com.example.moviescompose.features.favorites.domain.model.FavoriteMovieModel

data class FavoriteMoviesState(
    val favorites: List<FavoriteMovieModel> = emptyList(),
    val isLoading: Boolean = true
)
