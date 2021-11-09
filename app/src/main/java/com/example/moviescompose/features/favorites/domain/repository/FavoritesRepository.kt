package com.example.moviescompose.features.favorites.domain.repository

import com.example.moviescompose.features.movieDetails.data.dataSource.dto.EntityMovieDetailsDto
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    fun getFavoriteMovies(): Flow<List<EntityMovieDetailsDto>>
}