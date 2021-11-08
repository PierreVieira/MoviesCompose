package com.example.moviescompose.features.home.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MoviesDto(
    @SerializedName("results")
    val results: List<MovieDto>
) {
    fun toMovies() = results.map { it.toMovie() }
}