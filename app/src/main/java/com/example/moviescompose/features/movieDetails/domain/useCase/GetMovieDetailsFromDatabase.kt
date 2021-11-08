package com.example.moviescompose.features.movieDetails.domain.useCase

import com.example.moviescompose.features.movieDetails.data.dataSource.dto.DatabaseMovieDetailsDto
import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import com.example.moviescompose.util.Resource
import com.example.moviescompose.util.exceptions.NotFoundMovieDetailsException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDetailsFromDatabase @Inject constructor(
    private val getMovieDetailsFromDatabaseAction : suspend (Int) -> DatabaseMovieDetailsDto?
) {

    @Throws(NotFoundMovieDetailsException::class)
    operator fun invoke(movieId: Int): Flow<Resource<MovieDetails>> = flow {
        emit(Resource.Loading<MovieDetails>())
        val movieDetails = getMovieDetailsFromDatabaseAction(movieId)?.toMovieDetails()
        movieDetails?.let {
            emit(Resource.Success<MovieDetails>(it))
        } ?: run {
            val exception = NotFoundMovieDetailsException()
            emit(Resource.Error<MovieDetails>(exception.message))
            throw exception
        }
    }
}