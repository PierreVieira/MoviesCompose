package com.example.moviescompose.features.movieDetails.presentation.components.info.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.moviescompose.ui.theme.SourceSansPro

@Composable
fun MovieDetailsTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = 24.sp,
            fontFamily = SourceSansPro,
            fontWeight = FontWeight.Bold
        ),
        maxLines = 3
    )
}

@Composable
@Preview(showBackground = true)
private fun MovieDetailsTitlePreview() {
    MovieDetailsTitle(title = "Star Wars: The Rise of Skywalker (2019)")
}