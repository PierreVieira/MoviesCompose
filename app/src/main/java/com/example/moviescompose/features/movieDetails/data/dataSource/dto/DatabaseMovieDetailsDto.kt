package com.example.moviescompose.features.movieDetails.data.dataSource.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moviescompose.features.movieDetails.data.repository.MovieDetailsDto
import com.example.moviescompose.features.movieDetails.domain.model.Genre
import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import com.example.moviescompose.util.ApiConstants
import com.example.moviescompose.util.Converters
import com.example.moviescompose.util.ToDomain

@Entity
data class DatabaseMovieDetailsDto(
    @PrimaryKey val id: Int,
    val originalTitle: String,
    val posterPath: String?,
    val releaseDate: String,
    val title: String,
    val voteAverage: Float,
    val backdropPath: String?,
    val genres: String
) : MovieDetailsDto {

    override fun toMovieDetails() = MovieDetails(
        id = id,
        title = originalTitle,
        score = (voteAverage * 10).toInt(),
        releaseDate = ToDomain.toReleaseDate(releaseDate),
        posterUrl = ApiConstants.POSTER_BASE_URL + posterPath,
        backdropUrl = ApiConstants.BACKDROP_BASE_URL + backdropPath,
        originalTitle = originalTitle,
        genres = Converters.jsonToList(genres).map { Genre(it) }
    )

}