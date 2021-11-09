package com.example.moviescompose.features.movieDetails.presentation.components.appBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviescompose.R
import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import com.example.moviescompose.ui.components.BackIcon
import com.example.moviescompose.util.MovieDetailsPreviewData

@Composable
fun MovieDetailsAppBar(
    filled: Boolean,
    backClick: () -> Unit,
    favoriteIconClick: () -> Unit
) {
    TopAppBar(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BackIcon(backAction = backClick, color = Color.White)
            FavoriteIconButton(filled = filled, favoriteClick = favoriteIconClick)
        }
    }
}

@Composable
private fun FavoriteIconButton(
    filled: Boolean,
    favoriteClick: () -> Unit
) {
    FavoriteIcon(
        favoriteClick = {
            favoriteClick()
        },
        starIconId = if (filled) {
            R.drawable.ic_star
        } else {
            R.drawable.ic_star_border
        }
    )
}

@Composable
@Preview
private fun MovieDetailsAppBarPreview() {
    MovieDetailsAppBar(
        filled = false,
        backClick = {},
        favoriteIconClick = {}
    )
}