package com.example.moviescompose.features.favorites.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.moviescompose.R
import com.example.moviescompose.features.favorites.domain.model.FavoriteMovieModel
import com.example.moviescompose.navigation.Route
import com.example.moviescompose.ui.components.MovieImage
import com.example.moviescompose.util.TestTags

@Composable
fun FavoritesScreen(
    navController: NavController,
    favoritesViewModel: FavoritesViewModel = hiltViewModel()
) {
    val isLoading = favoritesViewModel.state.value.isLoading
    val favoritesList = favoritesViewModel.state.value.favorites
    when {
        isLoading -> Loading()
        favoritesList.isEmpty() -> EmptyFavorites()
        else -> FavoriteMoviesList(favoritesList, navController)
    }
}

@Composable
private fun FavoriteMoviesList(
    favoritesList: List<FavoriteMovieModel>,
    navController: NavController
) {
    LazyColumn(modifier = Modifier.testTag(TestTags.FAVORITES_SCREEN)) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(favoritesList) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 16.dp)
                    .clickable {
                        navController.navigate(Route.Details.getDynamicRoute(it.id))
                    }
                    .testTag(TestTags.FAVORITE_MOVIE_CARD)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.width(48.dp)) {
                        MovieImage(
                            imageUrl = it.image,
                            iconPlaceholderSize = 24.dp
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = it.title,
                        maxLines = 1
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun EmptyFavorites() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .testTag(TestTags.FAVORITES_SCREEN),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(id = R.string.favorites_empty_message))
    }
}

@Composable
fun Loading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .testTag(TestTags.FAVORITES_SCREEN),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
