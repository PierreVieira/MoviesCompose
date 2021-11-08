package com.example.moviescompose.features.movieDetails.presentation.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.moviescompose.features.home.domain.model.ReleaseDate
import com.example.moviescompose.features.movieDetails.domain.model.Genre
import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import com.example.moviescompose.features.movieDetails.presentation.components.info.MovieDetailsInfo
import com.example.moviescompose.ui.components.MovieImage

@Composable
fun MovieDetailsNormalConnection(
    screenHeight: Dp,
    favoriteClick: (MovieDetails) -> Unit,
    movieDetails: MovieDetails
) {
    val posterOffset = (-32).dp
    val backgroundHeight = screenHeight * 0.35f
    val boxHeight = screenHeight - backgroundHeight
    MovieImage(
        modifier = Modifier
            .height(backgroundHeight)
            .fillMaxWidth(),
        imageUrl = movieDetails.backdropUrl
    )
    Box(
        modifier = Modifier
            .height(boxHeight)
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        MovieDetailsInfo(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .offset(y = posterOffset),
            movieDetails = movieDetails,
            favoriteClick = favoriteClick
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun MovieDetailsNormalConnectionPreview() {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val movieDetails = MovieDetails(
        id = 0,
        posterUrl = "/h5UzYZquMwO9FVn15R2eK2itmHu.jpg",
        releaseDate = ReleaseDate(
            day = 30,
            month = 9,
            year = 2021
        ),
        title = "Venom: Let There Be Carnage",
        score = 68,
        backdropUrl = "/lNyLSOKMMeUPr1RsL4KcRuIXwHt.jpg",
        genres = listOf(
            Genre("Ficcção científica"),
            Genre("Ação"),
            Genre("Aventura")
        ),
        overview = "O relacionamento entre Eddie e Venom (Tom Hardy) está evoluindo. Buscando a melhor forma de lidar com a inevitável simbiose, esse dois lados descobrem como viver juntos e, de alguma forma, se tornarem melhores juntos do que separados."
    )
    Column(modifier = Modifier.fillMaxSize()) {
        MovieDetailsNormalConnection(
            screenHeight = screenHeight,
            favoriteClick = {},
            movieDetails = movieDetails
        )
    }
}