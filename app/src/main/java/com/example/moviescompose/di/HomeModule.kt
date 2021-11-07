package com.example.moviescompose.di

import com.example.moviescompose.util.ApiConstants
import com.example.moviescompose.features.home.data.remote.MoviesListApi
import com.example.moviescompose.features.home.data.repository.MoviesListRepositoryImpl
import com.example.moviescompose.features.home.domain.repository.MoviesListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun provideMoviesListApi(): MoviesListApi = Retrofit.Builder()
        .baseUrl(ApiConstants.API_KEY)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MoviesListApi::class.java)

    @Provides
    @Singleton
    fun provideMoviesListRepository(api: MoviesListApi): MoviesListRepository =
        MoviesListRepositoryImpl(api)
}