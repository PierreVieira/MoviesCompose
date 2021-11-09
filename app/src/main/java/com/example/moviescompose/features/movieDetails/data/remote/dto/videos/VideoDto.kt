package com.example.moviescompose.features.movieDetails.data.remote.dto.videos

import com.example.moviescompose.features.movieDetails.domain.model.MovieVideo
import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("site")
    val site: String,
    @SerializedName("key")
    val key: String
) {
    fun toVideo() = MovieVideo(
        site = site,
        id = key
    )
}
