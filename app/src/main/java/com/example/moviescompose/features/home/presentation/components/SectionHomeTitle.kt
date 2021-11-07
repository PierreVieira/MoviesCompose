package com.example.moviescompose.features.home.presentation.components

import androidx.annotation.StringRes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.moviescompose.R
import com.example.moviescompose.ui.theme.SourceSansPro

@Composable
fun SectionHomeTitle(@StringRes textId: Int) {
    Text(
        text = stringResource(id = textId),
        style = TextStyle(
            fontFamily = SourceSansPro,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    )
}

@Composable
@Preview(showBackground = true)
fun SectionHomeTitlePreview() {
    SectionHomeTitle(textId = R.string.most_popular)
}