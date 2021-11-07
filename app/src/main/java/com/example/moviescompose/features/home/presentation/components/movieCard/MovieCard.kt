package com.example.moviescompose.features.home.presentation.components.movieCard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.moviescompose.features.home.domain.model.Movie
import com.example.moviescompose.features.home.domain.model.ReleaseDate
import com.example.moviescompose.features.home.presentation.components.movieCard.components.MovieCardText
import com.example.moviescompose.features.home.presentation.components.movieCard.components.MovieImage
import com.example.moviescompose.features.home.presentation.components.movieCard.components.ScoreBall

@ExperimentalMaterialApi
@Composable
fun MovieCard(
    movie: Movie,
    modifier: Modifier = Modifier,
    width: Dp = 155.dp,
    height: Dp = 330.dp,
    onClick: () -> Unit
) {
    val scoreBallDiameter = 30.dp
    val startMarginContent = 8.dp
    val imageCardHeight = height * 0.7f
    Card(
        modifier = modifier
            .height(height)
            .width(width)
            .shadow(4.dp),
        onClick = onClick,
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (movieImage, scoreBall, text) = createRefs()
            MovieImage(
                modifier = Modifier.constrainAs(movieImage) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    this@constrainAs.width = Dimension.fillToConstraints
                    this@constrainAs.height = Dimension.value(imageCardHeight)
                },
                imageUrl = movie.imageUrl
            )
            ScoreBall(
                modifier = Modifier.constrainAs(scoreBall) {
                    start.linkTo(
                        anchor = parent.start,
                        margin = startMarginContent
                    )
                    top.linkTo(
                        anchor = movieImage.bottom,
                        margin = -scoreBallDiameter / 2
                    )
                },
                score = movie.score,
                radius = scoreBallDiameter,
                fontSize = 10.sp,
                borderWidth = 2.dp
            )
            MovieCardText(
                modifier = Modifier.constrainAs(text) {
                    start.linkTo(
                        anchor = parent.start,
                        margin = startMarginContent
                    )
                    top.linkTo(
                        anchor = scoreBall.bottom,
                        margin = 4.dp
                    )
                },
                movieTitle = movie.title,
                releaseDate = movie.releaseDate
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