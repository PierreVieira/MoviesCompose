package com.example.moviescompose.features.movieDetails.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviescompose.features.movieDetails.domain.useCase.AddMovieDetails
import com.example.moviescompose.features.movieDetails.domain.useCase.DetailUseCases
import com.example.moviescompose.features.movieDetails.domain.useCase.GetMovieDetails
import com.example.moviescompose.features.movieDetails.domain.useCase.OpenVideoOnYoutube
import com.example.moviescompose.features.movieDetails.domain.useCase.RemoveMovieDetailsFromFavorites
import com.example.moviescompose.util.NetworkErrorMessages
import com.example.moviescompose.util.Resource
import com.example.moviescompose.util.RoutesParams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val useCases: DetailUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MovieDetailsState())
    val state: State<MovieDetailsState> = _state
    private var movieId: Int? = null
    private val _favoriteState: MutableState<Boolean> = mutableStateOf(false)
    val favoriteState: State<Boolean> = _favoriteState

    init {
        savedStateHandle.get<Int>(RoutesParams.MOVIE_ID)?.let {
            movieId = it
            getMovieDetails()
        }
    }

    fun getMovieDetails() {
        movieId?.let {
            useCases.getMovieDetails(it).onEach { result ->
                _state.value = when (result) {
                    is Resource.Success -> {
                        _favoriteState.value = result.data!!.favorite
                        MovieDetailsState(movieDetails = result.data)
                    }
                    is Resource.Error -> MovieDetailsState(
                        error = result.message ?: NetworkErrorMessages.UNEXPECTED
                    )
                    is Resource.Loading -> MovieDetailsState(isLoading = true)
                }
            }.launchIn(viewModelScope)
        }
    }

    fun favoriteClick() {
        state.value.movieDetails?.let {
            viewModelScope.launch {
                _favoriteState.value = !favoriteState.value
                if (favoriteState.value) {
                    useCases.addMovieDetails(it.copy(favorite = true))
                } else {
                    _favoriteState.value = false
                    useCases.removeMovieDetailsFromFavorites(it.id)
                }
            }
        }
    }

    fun openYoutubeVideo(videoId: String) = useCases.openVideoOnYoutube(videoId)
}