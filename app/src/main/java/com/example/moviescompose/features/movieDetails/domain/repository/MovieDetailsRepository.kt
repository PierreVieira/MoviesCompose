package com.example.moviescompose.features.movieDetails.domain.repository

import com.example.moviescompose.features.movieDetails.data.dataSource.dto.DatabaseMovieDetailsDto
import com.example.moviescompose.features.movieDetails.data.remote.dto.WebMovieDetailsDto

interface MovieDetailsRepository {
    suspend fun getMovieDetailsFromWebAction(id: Int): WebMovieDetailsDto
    suspend fun getMovieDetailsFromDatabase(id: Int): DatabaseMovieDetailsDto?
}