package com.example.moviescompose.util

import com.example.moviescompose.features.home.domain.model.ReleaseDate
import com.example.moviescompose.features.movieDetails.domain.model.Genre
import com.example.moviescompose.features.movieDetails.domain.model.MovieDetails

object MovieDetailsPreviewData {
    val movie = MovieDetails(
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
}