package com.example.moviescompose.features.movieDetails.presentation.components.info.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviescompose.R
import com.example.moviescompose.ui.components.SectionTitle
import com.example.moviescompose.ui.theme.OverviewDescription

@Composable
fun MovieOverview(
    overview: String,
    modifier: Modifier = Modifier
) {
    Column {
        SectionTitle(textId = R.string.overview)
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = overview,
            color = OverviewDescription
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun MovieOverviewPreview() {
    MovieOverview(overview = "O relacionamento entre Eddie e Venom (Tom Hardy) está evoluindo. Buscando a melhor forma de lidar com a inevitável simbiose, esse dois lados descobrem como viver juntos e, de alguma forma, se tornarem melhores juntos do que separados.")
}