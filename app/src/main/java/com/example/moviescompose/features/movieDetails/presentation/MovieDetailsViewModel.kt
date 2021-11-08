package com.example.moviescompose.features.movieDetails.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.moviescompose.features.movieDetails.domain.useCase.GetMovieDetails
import com.example.moviescompose.util.NetworkErrorMessages
import com.example.moviescompose.util.Resource
import com.example.moviescompose.util.RoutesParams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetails,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MovieDetailsState())
    val state: State<MovieDetailsState> = _state

    init {
        savedStateHandle.get<Int>(RoutesParams.MOVIE_ID)?.let { movieId ->
            getMovieDetails(movieId)
        }
    }

    private fun getMovieDetails(movieId: Int) {
        getMovieDetailsUseCase(movieId).onEach { result ->
            _state.value = when (result) {
                is Resource.Success -> MovieDetailsState(movieDetails = result.data)
                is Resource.Error -> MovieDetailsState(
                    error = result.message ?: NetworkErrorMessages.UNEXPECTED
                )
                is Resource.Loading -> MovieDetailsState(isLoading = true)
            }
        }
    }
}