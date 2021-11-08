package com.example.moviescompose.features.movieDetails.presentation

import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails

data class MovieDetailsState(
    val isLoading: Boolean = false,
    val movieDetails: MovieDetails? = null,
    val error: String = ""
)
