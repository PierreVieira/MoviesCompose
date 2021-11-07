package com.example.moviescompose.features.home.presentation.components.movieCard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.moviescompose.R
import com.example.moviescompose.ui.theme.MoviePlaceholderIcon
import com.example.moviescompose.ui.theme.SurfacePlaceholder

@Composable
fun MovieImage(
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    iconPlaceholderSize: Dp = 64.dp,
) {
    val painter = rememberImagePainter(
        data = imageUrl,
        builder = {
            crossfade(true)
        }
    )
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painter,
            contentDescription = null
        )
        (painter.state as? ImagePainter.State.Success)?.let {

        } ?: MovieImagePlaceholder(iconPlaceholderSize)
    }
}

@Composable
private fun MovieImagePlaceholder(iconPlaceholderSize: Dp) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = SurfacePlaceholder
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Icon(
                modifier = Modifier
                    .size(iconPlaceholderSize)
                    .align(Alignment.Center),
                painter = painterResource(id = R.drawable.ic_movie),
                contentDescription = null,
                tint = MoviePlaceholderIcon,
            )
        }
    }
}

@ExperimentalCoilApi
@Composable
@Preview
private fun MovieImagePreview() {
    MovieImage()
}