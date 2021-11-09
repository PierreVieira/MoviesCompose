package com.example.moviescompose.features.data.repository

import com.example.moviescompose.features.movieDetails.data.dataSource.dto.EntityMovieDetailsDto
import com.example.moviescompose.features.movieDetails.data.remote.dto.WebMovieDetailsDto
import com.example.moviescompose.features.movieDetails.data.remote.dto.videos.VideoDto
import com.example.moviescompose.features.movieDetails.data.remote.dto.videos.VideosDto
import com.example.moviescompose.features.movieDetails.domain.repository.MovieDetailsRepository
import com.example.moviescompose.util.ApiConstants
import com.example.moviescompose.util.Converters

class FakeMovieDetailsRepository : MovieDetailsRepository {

    private val database = mutableListOf(
        EntityMovieDetailsDto(
            id = FAKE_MOVIE_ID_FROM_DATABASE,
            title = "fake",
            posterPath = null,
            releaseDate = "2012-12-12",
            overview = "Isso aqui é um filme fake",
            score = 92,
            backdropPath = null,
            genres = Converters.listToJson(listOf("ação", "aventura")),
            favorite = true,
            videoSite = null,
            youtubeVideoId = null
        )
    )

    companion object {
        const val FAKE_WEB_MOVIE_TITLE = "fake web original title"
        const val FAKE_MOVIE_ID_FROM_WEB = 2
        const val FAKE_MOVIE_ID_FROM_DATABASE = 3
    }

    override suspend fun getMovieDetailsFromWeb(id: Int): WebMovieDetailsDto {
        return WebMovieDetailsDto(
            id = FAKE_MOVIE_ID_FROM_WEB,
            originalTitle = FAKE_WEB_MOVIE_TITLE,
            posterPath = null,
            releaseDate = "2012-12-12",
            overview = "Isso aqui é um filme fake",
            voteAverage = 9.2f,
            backdropPath = null,
            genres = emptyList()
        )
    }

    override suspend fun getMovieVideosFromWeb(id: Int): VideosDto {
        return VideosDto(
            result = listOf(
                VideoDto(
                    site = "site-fake.com",
                    key = "123"
                ),
                VideoDto(
                    site = "site-fake2.com",
                    key = "456"
                ),
                VideoDto(
                    site = ApiConstants.YOUTUBE_SITE_KEY,
                    key = "XK-MIqHz5tU"
                ),
                VideoDto(
                    site = "site-fake3.com",
                    key = "789"
                )
            )
        )
    }

    override suspend fun getMovieDetailsFromDatabase(id: Int): EntityMovieDetailsDto? {
        return database.firstOrNull { it.id == id }
    }

    override suspend fun removeMovieDetailsFromDatabaseById(id: Int) {
        database.removeIf { it.id == id }
    }

    override suspend fun insertMovieDetailsInDatabase(movieDetailsDto: EntityMovieDetailsDto) {
        database.add(movieDetailsDto)
    }
}