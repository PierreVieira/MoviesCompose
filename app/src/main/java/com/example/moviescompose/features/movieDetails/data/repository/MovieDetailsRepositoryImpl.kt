package com.example.moviescompose.features.movieDetails.data.repository

import com.example.moviescompose.features.movieDetails.data.dataSource.MovieDetailsDao
import com.example.moviescompose.features.movieDetails.data.dataSource.dto.DatabaseMovieDetailsDto
import com.example.moviescompose.features.movieDetails.data.remote.MovieDetailsApi
import com.example.moviescompose.features.movieDetails.data.remote.dto.WebMovieDetailsDto
import com.example.moviescompose.features.movieDetails.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val api: MovieDetailsApi,
    private val dao: MovieDetailsDao
) : MovieDetailsRepository {

    override suspend fun getMovieDetailsFromWebAction(id: Int): WebMovieDetailsDto =
        api.getMovieDetails(id)

    override suspend fun getMovieDetailsFromDatabase(id: Int): DatabaseMovieDetailsDto? =
        dao.getNoteById(id)

    override suspend fun removeMovieDetailsFromDatabaseById(id: Int) =
        dao.deleteMovieDetails(id)

    override suspend fun insertMovieDetailsInDatabase(movieDetailsDto: DatabaseMovieDetailsDto) =
        dao.insertMovieDetails(movieDetailsDto)

}