package com.example.moviescompose.features.home.presentation.components.movieCard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope
import androidx.constraintlayout.compose.Dimension
import com.example.moviescompose.R
import com.example.moviescompose.features.home.domain.model.Movie
import com.example.moviescompose.features.home.domain.model.ReleaseDate
import com.example.moviescompose.features.home.presentation.components.movieCard.components.MovieCardText
import com.example.moviescompose.features.home.presentation.components.movieCard.components.MovieImage
import com.example.moviescompose.features.home.presentation.components.movieCard.components.ScoreBall
import com.example.moviescompose.features.home.presentation.components.movieCard.content.MovieCardNormalContent
import com.example.moviescompose.features.home.presentation.components.movieCard.content.MovieCardShimmerContent

@ExperimentalMaterialApi
@Composable
fun MovieCard(
    movie: Movie?,
    modifier: Modifier = Modifier,
    width: Dp = dimensionResource(R.dimen.home_movie_card_width),
    height: Dp = dimensionResource(R.dimen.home_movie_card_height),
    onClick: () -> Unit
) {
    val scoreBallDiameter = 30.dp
    val startMarginContent = 8.dp
    val imageCardHeight = height * 0.7f
    Card(
        modifier = modifier
            .height(height)
            .width(width)
            .shadow(dimensionResource(R.dimen.home_movie_card_shadow)),
        onClick = onClick,
        elevation = dimensionResource(R.dimen.home_movie_card_elevation)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            movie?.let {
                MovieCardNormalContent(
                    scoreBallDiameter = scoreBallDiameter,
                    startMarginContent = startMarginContent,
                    imageCardHeight = imageCardHeight,
                    movie = it
                )
            } ?: MovieCardShimmerContent(
                scoreBallDiameter = scoreBallDiameter,
                startMarginContent = startMarginContent,
                imageCardHeight = imageCardHeight,
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
private fun MovieCardPreview() {
    val movie = Movie(
        id = 0,
        title = "Venom: Tempo de Carnificina",
        score = 65,
        releaseDate = ReleaseDate(
            day = 15,
            month = 10,
            year = 2021
        ),
        imageUrl = ""
    )
    MovieCard(
        movie = movie,
        onClick = {}
    )
}