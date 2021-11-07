package com.example.moviescompose.features.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.moviescompose.R

@Composable
fun HomeAppBar() {
    TopAppBar(
        elevation = 8.dp,
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.White
    ) {
        Image(
            modifier = Modifier.size(132.dp),
            painter = painterResource(id = R.drawable.tmdb_short_logo),
            contentDescription = null
        )
    }
}