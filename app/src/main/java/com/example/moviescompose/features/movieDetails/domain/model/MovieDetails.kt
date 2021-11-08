package com.example.moviescompose.features.movieDetails.domain.model

import com.example.moviescompose.features.home.domain.model.ReleaseDate

data class MovieDetails(
    val id: Int,
    val originalTitle: String,
    val posterUrl: String?,
    val releaseDate: ReleaseDate,
    val title: String,
    val score: Int,
    val backdropUrl: String?,
    val genres: List<Genre>
)
