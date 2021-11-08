package com.example.moviescompose.features.movieDetails.presentation.components.info.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviescompose.R
import com.example.moviescompose.features.home.domain.model.ReleaseDate
import com.example.moviescompose.ui.theme.MovieDetailsDateColor
import com.example.moviescompose.ui.theme.SourceSansPro

@Composable
fun MovieDetailsDate(releaseDate: ReleaseDate) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = R.drawable.ic_calendar),
            contentDescription = null,
            tint = MovieDetailsDateColor
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = releaseDate.toString(),
            style = TextStyle(
                fontFamily = SourceSansPro,
                fontSize = 14.sp,
                color = MovieDetailsDateColor
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MovieDetailsDatePreview() {
    MovieDetailsDate(
        ReleaseDate(
            day = 16,
            month = 12,
            year = 2019
        )
    )
}