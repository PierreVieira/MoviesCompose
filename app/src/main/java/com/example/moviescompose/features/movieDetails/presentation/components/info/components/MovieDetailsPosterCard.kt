package com.example.moviescompose.features.movieDetails.presentation.components.info.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviescompose.ui.components.MovieImage

@Composable
fun MovieDetailsPosterCard(
    modifier: Modifier = Modifier,
    imageUrl: String? = null
) {
    Card(
        modifier = modifier
            .height(175.dp)
            .width(115.dp)
            .shadow(8.dp)
    ) {
        MovieImage(
            imageUrl = imageUrl,
            iconPlaceholderSize = 32.dp
        )
    }
}

@Composable
@Preview
private fun MovieDetailsPosterCardPreview() {
    MovieDetailsPosterCard()
}