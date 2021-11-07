package com.example.moviescompose.features.home.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val score: Int,
    val releaseDate: ReleaseDate,
    val imageUrl: String?
)
