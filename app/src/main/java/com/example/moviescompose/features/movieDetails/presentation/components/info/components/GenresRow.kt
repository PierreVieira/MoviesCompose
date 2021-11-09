package com.example.moviescompose.features.movieDetails.presentation.components.info.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviescompose.features.movieDetails.domain.model.Genre
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun GenresRow(genres: List<Genre>) {
    FlowRow(
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        genres.forEach { genre ->
            GenreCapsule(text = genre.name)
        }
    }
}