package com.example.moviescompose.features.home.presentation.components.movieCard.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviescompose.R
import com.example.moviescompose.ui.theme.BackgroundCircle
import com.example.moviescompose.ui.theme.ScoreHigh
import com.example.moviescompose.ui.theme.ScoreHighShadow
import com.example.moviescompose.ui.theme.ScoreLesser
import com.example.moviescompose.ui.theme.ScoreLesserShadow
import com.example.moviescompose.ui.theme.ScoreMedium
import com.example.moviescompose.ui.theme.ScoreMediumShadow
import com.example.moviescompose.ui.theme.SourceSansPro

@Composable
fun ScoreBall(
    score: Int,
    modifier: Modifier = Modifier,
    radius: Dp = dimensionResource(R.dimen.score_ball_default_radius),
    fontSize: TextUnit = 16.sp,
    borderWidth: Dp = 2.4.dp,
    backGroundColor: Color = BackgroundCircle,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    val percentage = score.toFloat() / 100
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
    val currentPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )
    val scoreAnimated = animateIntAsState(
        targetValue = if (animationPlayed) score else 0,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )

    Surface(
        modifier = modifier.size(radius),
        shape = CircleShape,
        color = backGroundColor,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Border(
                radius = radius,
                colors = getColorScore(score),
                percentage = currentPercentage.value,
                borderWidth = borderWidth
            )
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "${scoreAnimated.value}",
                style = TextStyle(
                    color = Color.White,
                    fontSize = fontSize,
                    fontFamily = SourceSansPro,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}

@Composable
private fun Border(
    radius: Dp,
    colors: Pair<Color, Color>,
    percentage: Float,
    borderWidth: Dp
) {
    val mainBorderColor = colors.first
    val shadowBorderColor = colors.second

    Box(modifier = Modifier.padding(4.dp)) {
        BorderCanvas(
            radius = radius,
            color = shadowBorderColor,
            borderWidth = borderWidth,
            percentage = 1f
        )
        BorderCanvas(
            radius = radius,
            color = mainBorderColor,
            borderWidth = borderWidth,
            percentage = percentage
        )
    }
}

@Composable
private fun BorderCanvas(
    radius: Dp,
    color: Color,
    borderWidth: Dp,
    percentage: Float
) {
    Canvas(modifier = Modifier.size(radius * 2f)) {
        drawArc(
            color = color,
            startAngle = -90f,
            sweepAngle = 360 * percentage,
            useCenter = false,
            style = Stroke(
                width = borderWidth.toPx(),
                cap = StrokeCap.Round
            )
        )
    }
}

private fun getColorScore(score: Int) = when {
    score < 40 -> Pair(ScoreLesser, ScoreLesserShadow)
    score < 75 -> Pair(ScoreMedium, ScoreMediumShadow)
    else -> Pair(ScoreHigh, ScoreHighShadow)
}


@Composable
@Preview(showBackground = true)
private fun ScoreCirclePreview() {
    ScoreBall(score = 85)
}
