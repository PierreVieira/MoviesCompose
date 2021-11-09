package com.example.moviescompose.features.movieDetails.presentation.components.appBar

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviescompose.R
import com.example.moviescompose.util.TestTags

@Composable
fun FavoriteIcon(
    favoriteClick: () -> Unit,
    starIconId: Int,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier.testTag(TestTags.FAVORITE_BUTTON),
        onClick = favoriteClick
    ) {
        Icon(
            painter = painterResource(id = starIconId),
            contentDescription = "Favorite Icon",
            tint = Color.Yellow
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun FavoriteSectionPreview() {
    FavoriteIcon(favoriteClick = {}, starIconId = R.drawable.ic_star)
}
