package com.example.moviescompose.features.home.presentation.components.movieCard.content

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayoutScope
import androidx.constraintlayout.compose.Dimension
import com.example.moviescompose.ui.theme.LoadingImageCard
import com.example.moviescompose.ui.theme.LoadingScoreBallCard
import com.example.moviescompose.ui.theme.LoadingTextCard
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@ExperimentalMaterialApi
@Composable
fun ConstraintLayoutScope.MovieCardShimmerContent(
    scoreBallDiameter: Dp,
    startMarginContent: Dp,
    imageCardHeight: Dp,
) {
    val (image, ball, title, date) = createRefs()
    Surface(
        modifier = Modifier
            .constrainAs(image) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                this@constrainAs.width = Dimension.fillToConstraints
                this@constrainAs.height = Dimension.value(imageCardHeight)
            }
            .shimmer(),
        color = LoadingImageCard
    ) {}
    Surface(
        modifier = Modifier
            .constrainAs(ball) {
                start.linkTo(
                    anchor = parent.start,
                    margin = startMarginContent
                )
                top.linkTo(
                    anchor = image.bottom,
                    margin = -scoreBallDiameter / 2
                )
            }
            .size(scoreBallDiameter)
            .shimmer(),
        shape = CircleShape,
        color = LoadingScoreBallCard
    ) {}
    Spacer(modifier = Modifier.height(8.dp))
    Surface(
        modifier = Modifier
            .constrainAs(title) {
                start.linkTo(
                    anchor = parent.start,
                    margin = startMarginContent
                )
                top.linkTo(
                    anchor = ball.bottom,
                    margin = 4.dp
                )
                this@constrainAs.width = Dimension.value(120.dp)
                this@constrainAs.height = Dimension.value(20.dp)
            }
            .shimmer(),
        color = LoadingTextCard
    ) {}
    Spacer(modifier = Modifier.height(2.dp))
    Surface(
        modifier = Modifier
            .constrainAs(date) {
                start.linkTo(
                    anchor = parent.start,
                    margin = startMarginContent
                )
                top.linkTo(
                    anchor = title.bottom,
                    margin = 4.dp
                )
                this@constrainAs.width = Dimension.value(80.dp)
                this@constrainAs.height = Dimension.value(20.dp)
            }
            .shimmer(),
        color = LoadingTextCard
    ) {}
}