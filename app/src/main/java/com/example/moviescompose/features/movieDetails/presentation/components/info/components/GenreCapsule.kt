package com.example.moviescompose.features.movieDetails.presentation.components.info.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.moviescompose.ui.theme.SourceSansPro

@Composable
fun GenreCapsule(text: String) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(8.dp)
    ) {
        Text(
            text = text,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            fontFamily = SourceSansPro
        )
    }
}