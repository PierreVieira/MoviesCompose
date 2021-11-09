package com.example.moviescompose.features.favorites.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviescompose.features.favorites.domain.useCase.GetFavorites
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavorites: GetFavorites
) : ViewModel() {

    private var getMoviesJob: Job? = null
    private val _state = mutableStateOf(FavoriteMoviesState())
    val state: State<FavoriteMoviesState> = _state

    init {
        getFavoriteMovies()
    }

    private fun getFavoriteMovies() {
        getMoviesJob?.cancel()
        getMoviesJob = getFavorites().onEach {
            _state.value = state.value.copy(favorites = it, isLoading = false)
        }.launchIn(viewModelScope)
    }
}