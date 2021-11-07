package com.example.moviescompose.features.home.domain.model

import androidx.annotation.StringRes
import com.example.moviescompose.features.home.presentation.states.MoviesListState

data class HomeSection(
    @StringRes val textId: Int,
    val state: MoviesListState
)
