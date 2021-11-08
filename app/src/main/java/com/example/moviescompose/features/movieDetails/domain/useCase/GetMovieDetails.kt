package com.example.moviescompose.features.movieDetails.domain.useCase

import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import com.example.moviescompose.util.Resource
import com.example.moviescompose.util.exceptions.NotFoundMovieDetailsException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDetails @Inject constructor(
    private val getFromWeb: GetMovieDetailsFromWeb,
    private val getFromDatabase: GetMovieDetailsFromDatabase,
) {
    operator fun invoke(movieId: Int): Flow<Resource<MovieDetails>> = flow {
        try {
            getFromDatabase(movieId)
        } catch (e: NotFoundMovieDetailsException) {
            getFromWeb(movieId)
        }
    }
}