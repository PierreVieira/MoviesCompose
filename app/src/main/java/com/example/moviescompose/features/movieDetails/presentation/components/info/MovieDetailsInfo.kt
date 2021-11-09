package com.example.moviescompose.features.movieDetails.presentation.components.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviescompose.R
import com.example.moviescompose.features.home.presentation.components.movieCard.components.ScoreBall
import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import com.example.moviescompose.features.movieDetails.presentation.components.info.components.MovieDetailsDate
import com.example.moviescompose.features.movieDetails.presentation.components.info.components.MovieDetailsPosterCard
import com.example.moviescompose.features.movieDetails.presentation.components.info.components.MovieDetailsTitle
import com.example.moviescompose.util.MovieDetailsPreviewData

@Composable
fun MovieDetailsInfo(
    movieDetailsPosterCard: @Composable RowScope.() -> Unit,
    movieDetails: MovieDetails,
) {
    Row(verticalAlignment = Alignment.Top) {
        movieDetailsPosterCard()
        Spacer(modifier = Modifier.width(24.dp))
        Column {
            MovieDetailsTitle(
                title = movieDetails.title,
            )
            Spacer(modifier = Modifier.height(8.dp))
            MovieDetailsDate(
                releaseDate = movieDetails.releaseDate
            )
            Spacer(modifier = Modifier.height(8.dp))
            ScoreBall(
                score = movieDetails.score,
                radius = dimensionResource(id = R.dimen.score_ball_default_radius),
                fontSize = 13.sp,
                borderWidth = 2.dp
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun MovieDetailsInfoPreview() {
    MovieDetailsInfo(
        movieDetails = MovieDetailsPreviewData.movie,
        movieDetailsPosterCard = {
            MovieDetailsPosterCard(imageUrl = MovieDetailsPreviewData.movie.posterUrl)
        }
    )
}