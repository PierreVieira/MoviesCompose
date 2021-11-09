package com.example.moviescompose.features.movieDetails.domain.useCase

import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import com.example.moviescompose.features.movieDetails.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class AddMovieDetails @Inject constructor(
    private val repository: MovieDetailsRepository
) {
    suspend operator fun invoke(movieDetails: MovieDetails) =
        repository.insertMovieDetailsInDatabase(movieDetails.toDatabaseDto())
}