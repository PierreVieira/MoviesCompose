package com.example.moviescompose.features.movieDetails.presentation.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.moviescompose.R
import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import com.example.moviescompose.features.movieDetails.domain.model.MovieVideo
import com.example.moviescompose.features.movieDetails.presentation.components.info.MovieDetailsInfo
import com.example.moviescompose.features.movieDetails.presentation.components.info.components.GenresRow
import com.example.moviescompose.features.movieDetails.presentation.components.info.components.MovieDetailsPosterCard
import com.example.moviescompose.features.movieDetails.presentation.components.info.components.MovieOverview
import com.example.moviescompose.ui.components.MovieImage
import com.example.moviescompose.util.ApiConstants
import com.example.moviescompose.util.MovieDetailsPreviewData

@Composable
fun MovieDetailsNormalConnection(
    screenHeight: Dp,
    movieDetails: MovieDetails,
    openYoutubeLink: (String) -> Unit
) {
    val posterOffset = (-24).dp
    val backgroundHeight = screenHeight * 0.35f
    val boxHeight = screenHeight - backgroundHeight
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        MovieImage(
            modifier = Modifier
                .height(backgroundHeight)
                .fillMaxWidth(),
            imageUrl = movieDetails.backdropUrl,
        )
        movieDetails.movieVideo?.let { movieVideo ->
            if (movieVideo.site == ApiConstants.YOUTUBE_SITE_KEY) {
                YoutubeVideoIconButton(
                    modifier = Modifier.align(Alignment.Center),
                    movieVideo = movieVideo,
                    openYoutubeLink = openYoutubeLink
                )
            }
        }
    }
    Box(
        modifier = Modifier
            .height(boxHeight)
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Spacer(modifier = Modifier.height(12.dp))
            MovieDetailsInfo(
                movieDetails = movieDetails,
                movieDetailsPosterCard = {
                    MovieDetailsPosterCard(
                        imageUrl = movieDetails.posterUrl,
                        modifier = Modifier.offset(y = posterOffset)
                    )
                }
            )
            GenresRow(genres = movieDetails.genres)
            Spacer(modifier = Modifier.height(16.dp))
            MovieOverview(overview = movieDetails.overview)
        }
    }
}

@Composable
private fun YoutubeVideoIconButton(
    modifier: Modifier = Modifier,
    movieVideo: MovieVideo,
    openYoutubeLink: (String) -> Unit
) {
    IconButton(
        modifier = modifier.shadow(8.dp),
        onClick = {
            movieVideo.id?.let { id ->
                openYoutubeLink(id)
            }
        }
    ) {
        Icon(
            modifier = Modifier.size(48.dp),
            painter = painterResource(id = R.drawable.ic_play_circle),
            contentDescription = stringResource(id = R.string.watch_video_on_youtube),
            tint = Color.White,
        )
    }
}