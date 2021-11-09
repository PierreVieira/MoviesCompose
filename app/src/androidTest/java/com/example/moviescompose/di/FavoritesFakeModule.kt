package com.example.moviescompose.di

import com.example.moviescompose.features.favorites.data.repository.FavoritesRepositoryImpl
import com.example.moviescompose.features.favorites.domain.repository.FavoritesRepository
import com.example.moviescompose.features.movieDetails.data.dataSource.MovieDetailsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoritesFakeModule {
    @Provides
    @Singleton
    fun providesFavoritesRepository(db: MovieDetailsDatabase): FavoritesRepository {
        return FavoritesRepositoryImpl(db.movieDetailsDao)
    }
}