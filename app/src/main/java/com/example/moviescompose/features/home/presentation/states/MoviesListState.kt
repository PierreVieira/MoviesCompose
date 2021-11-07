package com.example.moviescompose.features.home.presentation.states

import com.example.moviescompose.features.home.domain.model.Movie

data class MoviesListState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)
