package com.example.moviescompose.features.movieDetails.domain.useCase

import com.example.moviescompose.features.movieDetails.data.remote.dto.WebMovieDetailsDto
import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import com.example.moviescompose.util.NetworkErrorMessages
import com.example.moviescompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetMovieDetailsFromWeb @Inject constructor(
    private val getMovieDetailsFromWebAction: suspend (Int) -> WebMovieDetailsDto
) {
    operator fun invoke(movieId: Int) : Flow<Resource<MovieDetails>> = flow {
        try {
            emit(Resource.Loading<MovieDetails>())
            val movieDetails = getMovieDetailsFromWebAction(movieId).toMovieDetails()
            emit(Resource.Success<MovieDetails>(movieDetails))
        } catch (e: HttpException) {
            emit(Resource.Error<MovieDetails>(e.localizedMessage ?: NetworkErrorMessages.UNEXPECTED))
        } catch (e: IOException) {
            emit(Resource.Error<MovieDetails>(NetworkErrorMessages.SERVER))
        }
    }
}