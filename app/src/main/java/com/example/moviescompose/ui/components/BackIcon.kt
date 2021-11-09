package com.example.moviescompose.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import com.example.moviescompose.util.TestTags

@Composable
fun BackIcon(
    color: Color = Color.White,
    backAction: () -> Unit,
) {
    IconButton(
        modifier = Modifier.testTag(TestTags.BACK_BUTTON),
        onClick = { backAction() }
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            tint = color
        )
    }
}