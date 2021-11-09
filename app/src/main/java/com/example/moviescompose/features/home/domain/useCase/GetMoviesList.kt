package com.example.moviescompose.features.home.domain.useCase

import com.example.moviescompose.util.NetworkErrorMessages
import com.example.moviescompose.util.Resource
import com.example.moviescompose.features.home.domain.model.Movie
import com.example.moviescompose.features.home.domain.repository.MoviesListRepository
import com.example.moviescompose.features.home.domain.util.ListMoviesType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject


class GetMoviesList @Inject constructor(
    private val repository: MoviesListRepository
) {
    operator fun invoke(type: ListMoviesType): Flow<Resource<List<Movie>>> = flow {
        loadFromWeb(type)
    }

    private suspend fun FlowCollector<Resource<List<Movie>>>.loadFromWeb(
        type: ListMoviesType
    ) {
        try {
            emit(Resource.Loading())
            val movies = repository.getListMoviesByType(type).toMovies()
            emit(Resource.Success(movies))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: NetworkErrorMessages.UNEXPECTED))
        } catch (e: IOException) {
            emit(Resource.Error(NetworkErrorMessages.SERVER))
        }
    }
}