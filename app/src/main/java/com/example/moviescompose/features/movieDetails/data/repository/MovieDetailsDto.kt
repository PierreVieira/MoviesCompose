package com.example.moviescompose.features.movieDetails.data.repository

import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails

interface MovieDetailsDto {
    fun toMovieDetails(): MovieDetails
}