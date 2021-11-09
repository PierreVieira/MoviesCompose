package com.example.moviescompose.features.movieDetails.domain.useCase

import com.example.moviescompose.features.movieDetails.domain.model.MovieVideo
import com.example.moviescompose.features.movieDetails.domain.repository.MovieDetailsRepository
import com.example.moviescompose.util.ApiConstants
import javax.inject.Inject

class GetMovieVideo @Inject constructor(
    private val repository: MovieDetailsRepository
) {
    suspend operator fun invoke(movieId: Int): MovieVideo? {
        val movieVideosDto = repository.getMovieVideosFromWeb(movieId)
        return movieVideosDto.toVideos().firstOrNull { it.site == ApiConstants.YOUTUBE_SITE_KEY }
    }
}