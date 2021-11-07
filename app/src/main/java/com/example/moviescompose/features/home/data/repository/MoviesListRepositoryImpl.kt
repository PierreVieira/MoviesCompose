package com.example.moviescompose.features.home.data.repository

import com.example.moviescompose.features.home.data.remote.MoviesListApi
import com.example.moviescompose.features.home.data.remote.dto.MovieDto
import com.example.moviescompose.features.home.domain.util.ListMoviesType
import com.example.moviescompose.features.home.domain.repository.MoviesListRepository
import javax.inject.Inject

class MoviesListRepositoryImpl @Inject constructor(
    private val api: MoviesListApi
) : MoviesListRepository {

    override suspend fun getListMoviesByType(listMoviesType: ListMoviesType): List<MovieDto> =
        api.getListMoviesByType(listMoviesType.value)
}