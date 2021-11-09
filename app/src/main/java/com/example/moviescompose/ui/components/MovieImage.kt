package com.example.moviescompose.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
    @DrawableRes iconPlaceholderId: Int = R.drawable.ic_movie
) {
    val painter = rememberImagePainter(
        data = imageUrl,
        builder = {
            crossfade(true)
        }
    )
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        (painter.state as? ImagePainter.State.Success) ?: MovieImagePlaceholder(
            iconPlaceholderId = iconPlaceholderId,
            iconPlaceholderSize = iconPlaceholderSize
        )
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun MovieImagePlaceholder(
    @DrawableRes iconPlaceholderId: Int,
    iconPlaceholderSize: Dp
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = SurfacePlaceholder
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Icon(
                modifier = Modifier
                    .size(iconPlaceholderSize)
                    .align(Alignment.Center),
                painter = painterResource(id = iconPlaceholderId),
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