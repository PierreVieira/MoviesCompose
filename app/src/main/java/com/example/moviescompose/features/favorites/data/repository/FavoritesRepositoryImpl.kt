package com.example.moviescompose.features.favorites.data.repository

import com.example.moviescompose.features.favorites.domain.repository.FavoritesRepository
import com.example.moviescompose.features.movieDetails.data.dataSource.MovieDetailsDao
import com.example.moviescompose.features.movieDetails.data.dataSource.dto.EntityMovieDetailsDto
import kotlinx.coroutines.flow.Flow

class FavoritesRepositoryImpl(
    private val dao: MovieDetailsDao
) : FavoritesRepository {

    override fun getFavoriteMovies(): Flow<List<EntityMovieDetailsDto>> =
        dao.getAllMovieDetails()

}