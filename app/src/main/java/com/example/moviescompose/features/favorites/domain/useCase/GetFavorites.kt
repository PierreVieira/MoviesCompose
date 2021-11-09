package com.example.moviescompose.features.favorites.domain.useCase

import com.example.moviescompose.features.favorites.domain.model.FavoriteMovieModel
import com.example.moviescompose.features.favorites.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetFavorites @Inject constructor(
    private val repository: FavoritesRepository
) {
    operator fun invoke(): Flow<List<FavoriteMovieModel>> {
        return repository.getFavoriteMovies().map { listDto ->
            listDto.map { dto ->
                dto.toFavoriteMovieModel()
            }
        }
    }
}