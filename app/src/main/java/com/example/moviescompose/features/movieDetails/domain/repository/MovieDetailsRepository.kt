package com.example.moviescompose.features.movieDetails.domain.repository

import com.example.moviescompose.features.movieDetails.data.dataSource.dto.EntityMovieDetailsDto
import com.example.moviescompose.features.movieDetails.data.remote.dto.WebMovieDetailsDto
import com.example.moviescompose.features.movieDetails.data.remote.dto.videos.VideosDto

interface MovieDetailsRepository {
    suspend fun getMovieDetailsFromWeb(id: Int): WebMovieDetailsDto
    suspend fun getMovieVideosFromWeb(id: Int): VideosDto
    suspend fun getMovieDetailsFromDatabase(id: Int): EntityMovieDetailsDto?
    suspend fun removeMovieDetailsFromDatabaseById(id: Int)
    suspend fun insertMovieDetailsInDatabase(movieDetailsDto: EntityMovieDetailsDto)
}