package com.example.moviescompose.features.home.data.remote.dto


import com.example.moviescompose.features.home.domain.model.Movie
import com.example.moviescompose.features.home.domain.model.ReleaseDate
import com.example.moviescompose.util.ApiConstants
import com.google.gson.annotations.SerializedName

data class MovieDto(
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
    val voteAverage: Float
) {
    fun toMovie() = Movie(
        id = id,
        title = originalTitle,
        score = (voteAverage * 10).toInt(),
        releaseDate = toReleaseDate(releaseDate),
        imageUrl = ApiConstants.IMAGE_BASE_URL + posterPath
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