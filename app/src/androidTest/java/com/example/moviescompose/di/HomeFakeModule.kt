package com.example.moviescompose.di

import com.example.moviescompose.features.home.data.remote.MoviesListApi
import com.example.moviescompose.features.home.data.remote.dto.MovieDto
import com.example.moviescompose.features.home.data.remote.dto.MoviesDto
import com.example.moviescompose.features.home.domain.repository.MoviesListRepository
import com.example.moviescompose.features.home.domain.util.ListMoviesType
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeFakeModule {

    val mockedList = listOf(
        MovieDto(
            id = 580489,
            originalTitle = "Venom: Let There Be Carnag",
            posterPath = "/h5UzYZquMwO9FVn15R2eK2itmHu.jpg",
            releaseDate = "2021-09-30",
            title = "Venom: Tempo de Carnificina",
            voteAverage = 6.8f
        )
    )

    @Provides
    @Singleton
    fun provideMoviesListApi(): MoviesListApi = object : MoviesListApi {
        override suspend fun getListMoviesByType(type: String): MoviesDto {
            return MoviesDto(results = mockedList)
        }
    }

    @Provides
    @Singleton
    fun provideMoviesListRepository(api: MoviesListApi): MoviesListRepository =
        object : MoviesListRepository {
            override suspend fun getListMoviesByType(listMoviesType: ListMoviesType): MoviesDto {
                return MoviesDto(results = mockedList)
            }
        }
}