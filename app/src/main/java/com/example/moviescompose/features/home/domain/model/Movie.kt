package com.example.moviescompose.features.home.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val note: Int,
    val releaseDate: ReleaseDate,
    val posterPath: String
)
