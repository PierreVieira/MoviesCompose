package com.example.moviescompose.features.movieDetails.data.repository

import com.example.moviescompose.features.movieDetails.data.dataSource.MovieDetailsDao
import com.example.moviescompose.features.movieDetails.data.dataSource.dto.EntityMovieDetailsDto
import com.example.moviescompose.features.movieDetails.data.remote.MovieDetailsApi
import com.example.moviescompose.features.movieDetails.data.remote.dto.WebMovieDetailsDto
import com.example.moviescompose.features.movieDetails.data.remote.dto.videos.VideosDto
import com.example.moviescompose.features.movieDetails.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val api: MovieDetailsApi,
    private val dao: MovieDetailsDao
) : MovieDetailsRepository {

    override suspend fun getMovieDetailsFromWeb(id: Int): WebMovieDetailsDto =
        api.getMovieDetails(id)

    override suspend fun getMovieVideosFromWeb(id: Int): VideosDto =
        api.getMovieVideos(id)

    override suspend fun getMovieDetailsFromDatabase(id: Int): EntityMovieDetailsDto? =
        dao.getMovieDetailsById(id)

    override suspend fun removeMovieDetailsFromDatabaseById(id: Int) =
        dao.deleteMovieDetails(id)

    override suspend fun insertMovieDetailsInDatabase(movieDetailsDto: EntityMovieDetailsDto) =
        dao.insertMovieDetails(movieDetailsDto)

}