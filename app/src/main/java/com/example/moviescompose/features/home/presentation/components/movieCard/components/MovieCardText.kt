package com.example.moviescompose.features.home.presentation.components.movieCard.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviescompose.features.home.domain.model.ReleaseDate
import com.example.moviescompose.ui.theme.SourceSansPro
import com.example.moviescompose.ui.theme.Subtitle

@Composable
fun MovieCardText(
    movieTitle: String,
    releaseDate: ReleaseDate,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = movieTitle,
            maxLines = 2,
            style = TextStyle(
                fontFamily = SourceSansPro,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = releaseDate.toString(),
            style = TextStyle(
                fontFamily = SourceSansPro,
                fontWeight = FontWeight.Normal,
                color = Subtitle
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun MovieCardPreview() {
    MovieCardText(
        movieTitle = "Venom: Tempo de Carnificina",
        releaseDate = ReleaseDate(
            day = 30,
            month = 9,
            year = 2021
        )
    )
}