package com.example.moviescompose.features.movieDetails.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import com.example.moviescompose.features.movieDetails.domain.useCase.AddMovieDetails
import com.example.moviescompose.features.movieDetails.domain.useCase.GetMovieDetails
import com.example.moviescompose.features.movieDetails.domain.useCase.RemoveMovieDetailsFromFavorites
import com.example.moviescompose.util.NetworkErrorMessages
import com.example.moviescompose.util.Resource
import com.example.moviescompose.util.RoutesParams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetails,
    private val removeMovieDetailsFromFavorites: RemoveMovieDetailsFromFavorites,
    private val addMovieDetails: AddMovieDetails,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MovieDetailsState())
    val state: State<MovieDetailsState> = _state
    private var movieId: Int? = null

    init {
        savedStateHandle.get<Int>(RoutesParams.MOVIE_ID)?.let {
            movieId = it
            getMovieDetails()
        }
    }

    fun getMovieDetails() {
        movieId?.let {
            getMovieDetailsUseCase(it).onEach { result ->
                _state.value = when (result) {
                    is Resource.Success -> MovieDetailsState(movieDetails = result.data)
                    is Resource.Error -> MovieDetailsState(
                        error = result.message ?: NetworkErrorMessages.UNEXPECTED
                    )
                    is Resource.Loading -> MovieDetailsState(isLoading = true)
                }
            }.launchIn(viewModelScope)
        }
    }

    fun favoriteClick(movieDetails: MovieDetails) {
        viewModelScope.launch {
            if (movieDetails.favorite) {
                addMovieDetails(movieDetails)
            } else {
                removeMovieDetailsFromFavorites(movieDetails.id)
            }
        }
    }
}