package com.example.moviescompose.features.home.presentation.states

import androidx.compose.runtime.MutableState

data class HomeMutableState(
    val popularMoviesListState: MutableState<MoviesListState>,
    val nowPlayingMoviesListState: MutableState<MoviesListState>,
    val topRatedMoviesListState: MutableState<MoviesListState>,
    val upcomingMoviesListState: MutableState<MoviesListState>
)
