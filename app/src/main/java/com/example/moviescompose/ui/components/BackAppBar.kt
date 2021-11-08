package com.example.moviescompose.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BackAppBar(title: String, backAction: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { backAction() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        title = { Text(title) }
    )
}

@Composable
@Preview(showBackground = true)
private fun BackAppBarPreview() {
    BackAppBar(title = "Detalhes do filme") {

    }
}