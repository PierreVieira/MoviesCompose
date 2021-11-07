package com.example.moviescompose.features.home.domain.repository

import com.example.moviescompose.features.home.data.remote.dto.MovieDto
import com.example.moviescompose.features.home.domain.util.ListMoviesType

interface MoviesListRepository {
    suspend fun getListMoviesByType(listMoviesType: ListMoviesType) : List<MovieDto>
}