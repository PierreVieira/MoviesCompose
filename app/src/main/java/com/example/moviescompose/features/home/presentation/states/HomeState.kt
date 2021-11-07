package com.example.moviescompose.features.home.presentation.states

import androidx.compose.runtime.State

data class HomeState(
    val popularMoviesListState: State<MoviesListState>,
    val nowPlayingMoviesListState: State<MoviesListState>,
    val topRatedMoviesListState: State<MoviesListState>,
    val upcomingMoviesListState: State<MoviesListState>
)
