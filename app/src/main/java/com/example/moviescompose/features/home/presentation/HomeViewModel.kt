package com.example.moviescompose.features.home.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviescompose.R
import com.example.moviescompose.features.home.domain.model.HomeSection
import com.example.moviescompose.util.NetworkErrorMessages
import com.example.moviescompose.util.Resource
import com.example.moviescompose.features.home.domain.model.Movie
import com.example.moviescompose.features.home.domain.useCase.GetMoviesList
import com.example.moviescompose.features.home.domain.util.ListMoviesType
import com.example.moviescompose.features.home.presentation.states.HomeMutableState
import com.example.moviescompose.features.home.presentation.states.HomeState
import com.example.moviescompose.features.home.presentation.states.MoviesListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesList: GetMoviesList
) : ViewModel() {

    private val _homeState = HomeMutableState(
        popularMoviesListState = mutableStateOf(MoviesListState()),
        nowPlayingMoviesListState = mutableStateOf(MoviesListState()),
        topRatedMoviesListState = mutableStateOf(MoviesListState()),
        upcomingMoviesListState = mutableStateOf(MoviesListState())
    )

    private val homeState = HomeState(
        popularMoviesListState = _homeState.popularMoviesListState,
        nowPlayingMoviesListState = _homeState.nowPlayingMoviesListState,
        topRatedMoviesListState = _homeState.topRatedMoviesListState,
        upcomingMoviesListState = _homeState.upcomingMoviesListState
    )

    init {
        getAllMovies()
    }

    fun getAllMovies() {
        for (type in ListMoviesType.values()) {
            getMovies(type)
        }
    }

    private fun getMovies(type: ListMoviesType) {
        getMoviesList(type).onEach { result ->
            when (type) {
                ListMoviesType.POPULAR -> {
                    _homeState.popularMoviesListState.value = getMoviesListState(result)
                }
                ListMoviesType.TOP_RATED -> {
                    _homeState.topRatedMoviesListState.value = getMoviesListState(result)
                }
                ListMoviesType.NOW_PLAYING -> {
                    _homeState.nowPlayingMoviesListState.value = getMoviesListState(result)
                }
                ListMoviesType.UPCOMING -> {
                    _homeState.upcomingMoviesListState.value = getMoviesListState(result)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getMoviesListState(result: Resource<List<Movie>>) = when (result) {
        is Resource.Success -> MoviesListState(movies = result.data ?: emptyList())
        is Resource.Error -> MoviesListState(
            error = result.message ?: NetworkErrorMessages.UNEXPECTED
        )
        is Resource.Loading -> MoviesListState(isLoading = true)
    }

    fun getSections() = listOf(
        HomeSection(
            textId = R.string.most_popular,
            state = homeState.popularMoviesListState.value
        ),
        HomeSection(
            textId = R.string.top_rated,
            state = homeState.topRatedMoviesListState.value,
        ),
        HomeSection(
            textId = R.string.now_playing,
            state = homeState.nowPlayingMoviesListState.value,
        ),
        HomeSection(
            textId = R.string.upcoming,
            state = homeState.upcomingMoviesListState.value
        )
    )
}