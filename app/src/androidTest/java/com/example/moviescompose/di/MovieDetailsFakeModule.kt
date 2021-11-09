package com.example.moviescompose.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.moviescompose.features.movieDetails.data.dataSource.MovieDetailsDatabase
import com.example.moviescompose.features.movieDetails.data.remote.MovieDetailsApi
import com.example.moviescompose.features.movieDetails.data.remote.dto.WebMovieDetailsDto
import com.example.moviescompose.features.movieDetails.data.remote.dto.genres.GenreDto
import com.example.moviescompose.features.movieDetails.data.remote.dto.videos.VideoDto
import com.example.moviescompose.features.movieDetails.data.remote.dto.videos.VideosDto
import com.example.moviescompose.features.movieDetails.data.repository.MovieDetailsRepositoryImpl
import com.example.moviescompose.features.movieDetails.domain.repository.MovieDetailsRepository
import com.example.moviescompose.features.movieDetails.domain.useCase.AddMovieDetails
import com.example.moviescompose.features.movieDetails.domain.useCase.DetailUseCases
import com.example.moviescompose.features.movieDetails.domain.useCase.GetMovieDetails
import com.example.moviescompose.features.movieDetails.domain.useCase.GetMovieVideo
import com.example.moviescompose.features.movieDetails.domain.useCase.OpenVideoOnYoutube
import com.example.moviescompose.features.movieDetails.domain.useCase.RemoveMovieDetailsFromFavorites
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDetailsFakeModule {

    @Provides
    @Singleton
    fun provideMovieDetailsApi(): MovieDetailsApi = object : MovieDetailsApi {
        override suspend fun getMovieDetails(movieId: Int): WebMovieDetailsDto {
            return WebMovieDetailsDto(
                id = 580489,
                originalTitle = "Venom: Let There Be Carnage",
                posterPath = "/h5UzYZquMwO9FVn15R2eK2itmHu.jpg",
                releaseDate = "2021-09-30",
                overview = "O relacionamento entre Eddie e Venom (Tom Hardy) está evoluindo. Buscando a melhor forma de lidar com a inevitável simbiose, esse dois lados descobrem como viver juntos e, de alguma forma, se tornarem melhores juntos do que separados.",
                voteAverage = 6.8f,
                backdropPath = "/lNyLSOKMMeUPr1RsL4KcRuIXwHt.jpg",
                genres = listOf(
                    GenreDto("Ficção Científica"),
                    GenreDto("Ação"),
                    GenreDto("Aventura"),
                )
            )
        }

        override suspend fun getMovieVideos(movieId: Int): VideosDto {
            return VideosDto(
                result = listOf(
                    VideoDto(
                        site = "YouTube",
                        key = "XK-MIqHz5tU"
                    )
                )
            )
        }
    }

    @Provides
    @Singleton
    fun provideMovieDetailsDatabase(app: Application): MovieDetailsDatabase {
        return Room.inMemoryDatabaseBuilder(
            app,
            MovieDetailsDatabase::class.java
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDetailsRepository(
        api: MovieDetailsApi,
        db: MovieDetailsDatabase
    ): MovieDetailsRepository =
        MovieDetailsRepositoryImpl(api, db.movieDetailsDao)

    @Provides
    @Singleton
    fun provideOpenYoutubeVideoUseCase(@ApplicationContext context: Context) =
        OpenVideoOnYoutube(context)

    @Provides
    @Singleton
    fun provideUseCases(
        repository: MovieDetailsRepository,
        openVideoOnYoutube: OpenVideoOnYoutube
    ): DetailUseCases {
        return DetailUseCases(
            getMovieDetails = GetMovieDetails(repository, GetMovieVideo(repository)),
            addMovieDetails = AddMovieDetails(repository),
            openVideoOnYoutube = openVideoOnYoutube,
            removeMovieDetailsFromFavorites = RemoveMovieDetailsFromFavorites(repository)
        )
    }
}