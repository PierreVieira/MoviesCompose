package com.example.moviescompose.features.movieDetails.domain.model

import com.example.moviescompose.features.home.domain.model.ReleaseDate
import com.example.moviescompose.features.movieDetails.data.dataSource.dto.DatabaseMovieDetailsDto
import com.example.moviescompose.util.ApiConstants
import com.example.moviescompose.util.Converters

data class MovieDetails(
    val id: Int,
    val posterUrl: String?,
    val releaseDate: ReleaseDate,
    val overview: String,
    val title: String,
    val score: Int,
    val backdropUrl: String?,
    val genres: List<Genre>,
    val favorite: Boolean = false
) {
    fun toDatabaseDto(): DatabaseMovieDetailsDto {
        val releaseDateString = "${releaseDate.year}-${releaseDate.month}-${releaseDate.day}"
        val genresJson = Converters.listToJson(genres.map { it.name })
        return DatabaseMovieDetailsDto(
            id = id,
            title = title,
            score = score,
            overview = overview,
            favorite = favorite,
            releaseDate = releaseDateString,
            genres = genresJson,
            posterPath = posterUrl?.removePrefix(ApiConstants.POSTER_BASE_URL),
            backdropPath = backdropUrl?.removePrefix(ApiConstants.BACKDROP_BASE_URL)
        )
    }
}
