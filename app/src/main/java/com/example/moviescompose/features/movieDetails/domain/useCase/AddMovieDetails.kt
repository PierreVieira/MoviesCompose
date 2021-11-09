package com.example.moviescompose.features.movieDetails.domain.useCase

import com.example.moviescompose.features.movieDetails.data.dataSource.dto.EntityMovieDetailsDto
import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import javax.inject.Inject

class AddMovieDetails @Inject constructor(
    private val insertMovieDetailsAction: suspend (EntityMovieDetailsDto) -> Unit
) {
    suspend operator fun invoke(movieDetails: MovieDetails) =
        insertMovieDetailsAction(movieDetails.toDatabaseDto())
}