package com.example.moviescompose.features.home.presentation.components.movieCard.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayoutScope
import androidx.constraintlayout.compose.Dimension
import com.example.moviescompose.features.home.domain.model.Movie
import com.example.moviescompose.features.home.presentation.components.movieCard.components.MovieCardText
import com.example.moviescompose.ui.components.MovieImage
import com.example.moviescompose.features.home.presentation.components.movieCard.components.ScoreBall

@Composable
fun ConstraintLayoutScope.MovieCardNormalContent(
    scoreBallDiameter: Dp,
    startMarginContent: Dp,
    imageCardHeight: Dp,
    movie: Movie
) {
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