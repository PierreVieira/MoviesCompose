package com.example.moviescompose.features.movieDetails.domain.useCase

data class DetailUseCases(
    val getMovieDetails: GetMovieDetails,
    val addMovieDetails: AddMovieDetails,
    val openVideoOnYoutube: OpenVideoOnYoutube,
    val removeMovieDetailsFromFavorites: RemoveMovieDetailsFromFavorites
)