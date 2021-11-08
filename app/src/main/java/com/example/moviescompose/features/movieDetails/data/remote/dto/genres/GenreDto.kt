package com.example.moviescompose.features.movieDetails.data.remote.dto.genres

import com.example.moviescompose.features.movieDetails.domain.model.Genre
import com.google.gson.annotations.SerializedName

data class GenreDto(
    @SerializedName("name")
    val name: String
) {
    fun toGenre() = Genre(
        name = name
    )
}