package com.example.moviescompose.features.movieDetails.data.remote.dto

import com.example.moviescompose.features.movieDetails.data.remote.dto.genres.GenresDto
import com.example.moviescompose.features.movieDetails.data.repository.MovieDetailsDto
import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import com.example.moviescompose.util.ApiConstants
import com.example.moviescompose.util.ToDomain
import com.google.gson.annotations.SerializedName

data class WebMovieDetailsDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Float,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("genres")
    val genres: GenresDto
) : MovieDetailsDto {
    override fun toMovieDetails() = MovieDetails(
        id = id,
        title = originalTitle,
        score = (voteAverage * 10).toInt(),
        releaseDate = ToDomain.toReleaseDate(releaseDate),
        posterUrl = ApiConstants.POSTER_BASE_URL + posterPath,
        backdropUrl = ApiConstants.BACKDROP_BASE_URL + backdropPath,
        originalTitle = originalTitle,
        genres = genres.toGenres()
    )
}