package com.example.moviescompose.di

import android.app.Application
import androidx.room.Room
import com.example.moviescompose.features.movieDetails.data.dataSource.MovieDetailsDatabase
import com.example.moviescompose.features.movieDetails.data.remote.MovieDetailsApi
import com.example.moviescompose.features.movieDetails.data.repository.MovieDetailsRepositoryImpl
import com.example.moviescompose.features.movieDetails.domain.repository.MovieDetailsRepository
import com.example.moviescompose.features.movieDetails.domain.useCase.AddMovieDetails
import com.example.moviescompose.features.movieDetails.domain.useCase.GetMovieDetails
import com.example.moviescompose.features.movieDetails.domain.useCase.GetMovieDetailsFromDatabase
import com.example.moviescompose.features.movieDetails.domain.useCase.GetMovieDetailsFromWeb
import com.example.moviescompose.features.movieDetails.domain.useCase.RemoveMovieDetailsFromFavorites
import com.example.moviescompose.util.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDetailsModule {

    @Provides
    @Singleton
    fun provideMovieDetailsApi(): MovieDetailsApi = Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieDetailsApi::class.java)

    @Provides
    @Singleton
    fun provideMovieDetailsDatabase(app: Application): MovieDetailsDatabase {
        return Room.databaseBuilder(
            app,
            MovieDetailsDatabase::class.java,
            MovieDetailsDatabase.DATABASE_NAME
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
    fun provideGetMovieDetailsFromWeb(repository: MovieDetailsRepository) =
        GetMovieDetailsFromWeb(
            getMovieDetailsFromWebAction = {
                repository.getMovieDetailsFromWebAction(it)
            }
        )

    @Provides
    @Singleton
    fun provideGetMovieDetailsFromDatabase(repository: MovieDetailsRepository) =
        GetMovieDetailsFromDatabase(
            getMovieDetailsFromDatabaseAction = {
                repository.getMovieDetailsFromDatabase(it)
            }
        )

    @Provides
    @Singleton
    fun provideGetMovieDetails(
        getFromWeb: GetMovieDetailsFromWeb,
        getFromDatabase: GetMovieDetailsFromDatabase
    ): GetMovieDetails = GetMovieDetails(getFromWeb, getFromDatabase)

    @Provides
    @Singleton
    fun provideAddMovieDetails(
        repository: MovieDetailsRepository
    ): AddMovieDetails = AddMovieDetails(
        insertMovieDetailsAction = {
            repository.insertMovieDetailsInDatabase(it)
        }
    )

    @Provides
    @Singleton
    fun provideRemoveMovieDetailsFromFavorites(repository: MovieDetailsRepository): RemoveMovieDetailsFromFavorites =
        RemoveMovieDetailsFromFavorites(
            removeMovieDetailsAction = { movieId ->
                repository.removeMovieDetailsFromDatabaseById(movieId)
            }
        )
}