package com.example.moviescompose.features.movieDetails.domain.useCase

import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import com.example.moviescompose.features.movieDetails.domain.repository.MovieDetailsRepository
import com.example.moviescompose.util.NetworkErrorMessages
import com.example.moviescompose.util.Resource
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class GetMovieDetails(
    private val repository: MovieDetailsRepository,
    private val getMovieVideos: GetMovieVideo
) {
    operator fun invoke(movieId: Int) = flow {
        emit(Resource.Loading())
        loadFromDatabase(movieId)?.let {
            emit(Resource.Success(it))
        } ?: loadFromWeb(movieId)
    }

    private suspend fun loadFromDatabase(movieId: Int) =
        repository.getMovieDetailsFromDatabase(movieId)?.toMovieDetails()

    private suspend fun FlowCollector<Resource<MovieDetails>>.loadFromWeb(movieId: Int) {
        try {
            val movieDetails = repository.getMovieDetailsFromWeb(movieId).toMovieDetails()
            val movieVideo = getMovieVideos(movieId)
            emit(Resource.Success(movieDetails.copy(movieVideo = movieVideo)))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: NetworkErrorMessages.UNEXPECTED
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error(NetworkErrorMessages.SERVER))
        }
    }
}