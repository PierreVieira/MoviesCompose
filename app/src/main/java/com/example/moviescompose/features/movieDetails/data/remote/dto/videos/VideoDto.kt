package com.example.moviescompose.features.movieDetails.data.remote.dto.videos

import com.example.moviescompose.features.movieDetails.domain.model.Video
import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("site")
    val site: String,
    @SerializedName("key")
    val key: String
) {
    fun toVideo() = Video(
        site = site,
        key = key
    )
}
