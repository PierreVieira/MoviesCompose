package com.example.moviescompose.features.movieDetails.presentation.components.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviescompose.features.home.domain.model.ReleaseDate
import com.example.moviescompose.features.movieDetails.domain.model.Genre
import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails
import com.example.moviescompose.features.movieDetails.presentation.components.info.components.FavoriteSection
import com.example.moviescompose.features.movieDetails.presentation.components.info.components.MovieDetailsDate
import com.example.moviescompose.features.movieDetails.presentation.components.info.components.MovieDetailsPosterCard
import com.example.moviescompose.features.movieDetails.presentation.components.info.components.MovieDetailsTitle
import com.example.moviescompose.features.movieDetails.presentation.components.info.components.MovieOverview

@Composable
fun MovieDetailsInfo(
    movieDetails: MovieDetails,
    favoriteClick: (MovieDetails) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            MovieDetailsPosterCard(
                imageUrl = movieDetails.posterUrl
            )
            Spacer(modifier = Modifier.width(24.dp))
            Column {
                MovieDetailsTitle(
                    title = movieDetails.title,
                )
                Spacer(modifier = Modifier.height(8.dp))
                MovieDetailsDate(
                    releaseDate = movieDetails.releaseDate
                )
                Spacer(modifier = Modifier.height(8.dp))
                FavoriteSection(
                    movieDetails = movieDetails,
                    favoriteClick = favoriteClick
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        MovieOverview(
            overview = movieDetails.overview,
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun MovieDetailsInfoPreview() {
    val movieDetails = MovieDetails(
        id = 0,
        posterUrl = "/h5UzYZquMwO9FVn15R2eK2itmHu.jpg",
        releaseDate = ReleaseDate(
            day = 30,
            month = 9,
            year = 2021
        ),
        title = "Venom: Let There Be Carnage",
        score = 68,
        backdropUrl = "/lNyLSOKMMeUPr1RsL4KcRuIXwHt.jpg",
        genres = listOf(
            Genre("Ficcção científica"),
            Genre("Ação"),
            Genre("Aventura")
        ),
        overview = "O relacionamento entre Eddie e Venom (Tom Hardy) está evoluindo. Buscando a melhor forma de lidar com a inevitável simbiose, esse dois lados descobrem como viver juntos e, de alguma forma, se tornarem melhores juntos do que separados."
    )
    MovieDetailsInfo(movieDetails = movieDetails, favoriteClick = {})
}