package com.example.moviescompose.presentation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.filters.LargeTest
import com.example.moviescompose.di.FavoritesModule
import com.example.moviescompose.di.HomeModule
import com.example.moviescompose.di.MovieDetailsModule
import com.example.moviescompose.ui.MainActivity
import com.example.moviescompose.ui.components.AppComponent
import com.example.moviescompose.util.TestTags
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(FavoritesModule::class, HomeModule::class, MovieDetailsModule::class)
@LargeTest
class MoviesEndToEndTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @ExperimentalMaterialApi
    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            AppComponent()
        }
    }

    @Test
    fun checkBottomNavigationBar() {
        navFromHomeToFavorites()
        navFromFavoritesToHome()
    }

    @Test
    fun checkMovieDetailsNavigation() {
        navFromHomeToMovieDetails()
        navFromMovieDetailsToHome()
    }

    @Test
    fun checkIfMovieIsAddedToFavoritesScreen() {
        favoriteMovieAndGoToFavoritesScreen()
    }

    @Test
    fun checkIfDisfavorMovieDisappearOnFavoritesScreen(){
        favoriteMovieAndGoToFavoritesScreen()
        goToDetailsFromFavorites()
        composeRule.onNodeWithTag(TestTags.FAVORITE_BUTTON).performClick()
        composeRule.onNodeWithTag(TestTags.BACK_BUTTON).performClick()
        composeRule.onNodeWithTag(TestTags.FAVORITE_MOVIE_CARD).assertDoesNotExist()
    }

    private fun goToDetailsFromFavorites() {
        composeRule.onNodeWithTag(TestTags.FAVORITE_MOVIE_CARD).performClick()
    }

    private fun favoriteMovieAndGoToFavoritesScreen() {
        navFromHomeToMovieDetails()
        clickOnFavoriteButton()
        navFromMovieDetailsToHome()
        navFromHomeToFavorites()
        composeRule.onNodeWithTag(TestTags.FAVORITE_MOVIE_CARD).assertIsDisplayed()
    }

    private fun clickOnFavoriteButton() {
        composeRule.onNodeWithTag(TestTags.FAVORITE_BUTTON).performClick()
    }

    private fun navFromMovieDetailsToHome() {
        composeRule.apply {
            onNodeWithTag(TestTags.BACK_BUTTON).performClick()
            onNodeWithTag(TestTags.HOME_SCREEN).assertIsDisplayed()
        }
    }

    private fun navFromHomeToMovieDetails() {
        composeRule.apply {
            onNodeWithTag(TestTags.HOME_SCREEN).assertIsDisplayed()
            onNodeWithTag("${TestTags.HOME_MOVIE_CARD} 0 0").performClick()
            onNodeWithTag(TestTags.MOVIE_DETAILS_SCREEN).assertIsDisplayed()
        }
    }

    private fun navFromHomeToFavorites() {
        composeRule.apply {
            onNodeWithTag(TestTags.HOME_SCREEN).assertIsDisplayed()
            onNodeWithTag(TestTags.FAVORITES_ICON).performClick()
            onNodeWithTag(TestTags.FAVORITES_SCREEN).assertIsDisplayed()
        }
    }

    private fun navFromFavoritesToHome() {
        composeRule.apply {
            onNodeWithTag(TestTags.FAVORITES_SCREEN).assertIsDisplayed()
            onNodeWithTag(TestTags.HOME_ICON).performClick()
            onNodeWithTag(TestTags.HOME_SCREEN).assertIsDisplayed()
        }
    }
}