package com.example.moviescompose.ui.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BackAppBar(title: String?, backAction: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            BackIcon(backAction = backAction)
        },
        title = {
            title?.let {
                Text(it)
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
private fun BackAppBarPreview() {
    BackAppBar(title = "Detalhes do filme") {

    }
}