package com.example.moviescompose.features.movieDetails.domain.useCase

import javax.inject.Inject


class RemoveMovieDetailsFromFavorites @Inject constructor(
    private val removeMovieDetailsAction: suspend (Int) -> Unit
) {
    suspend operator fun invoke(id: Int) = removeMovieDetailsAction(id)
}