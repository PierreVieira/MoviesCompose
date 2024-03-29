package com.example.moviescompose.features.home.data.remote

import com.example.moviescompose.util.ApiConstants
import com.example.moviescompose.features.home.data.remote.dto.MovieDto
import com.example.moviescompose.features.home.data.remote.dto.MoviesDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesListApi {

    @GET("movie/{type}?${ApiConstants.QUERY_DEFAULT}")
    suspend fun getListMoviesByType(@Path("type") type: String): MoviesDto

}