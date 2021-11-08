package com.example.moviescompose.features.movieDetails.data.remote.dto.genres

import com.google.gson.annotations.SerializedName

data class GenresDto(
    @SerializedName("genres")
    val genres: List<GenreDto>
) {
    fun toGenres() = genres.map { it.toGenre() }
}
