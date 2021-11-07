package com.example.moviescompose.features.home.data.remote.dto


import com.example.moviescompose.features.home.domain.model.Movie
import com.example.moviescompose.features.home.domain.model.ReleaseDate
import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
) {
    fun toMovie() = Movie(
        id = id,
        title = originalTitle,
        note = (voteAverage * 10).toInt(),
        releaseDate = toReleaseDate(releaseDate),
        posterPath = posterPath
    )

    private fun toReleaseDate(releaseDate: String): ReleaseDate {
        val releaseDateSplit = releaseDate.split("-")
        val day = releaseDateSplit[2].toInt()
        val month = releaseDateSplit[1].toInt()
        val year = releaseDateSplit[0].toInt()
        return ReleaseDate(
            day = day,
            month = month,
            year = year
        )
    }
}