package com.example.moviescompose.features.home.domain.model

import com.google.common.truth.Truth
import org.junit.Test

class ReleaseDateTest {

    @Test
    fun `check release date to string format`() {
        val releaseDate = ReleaseDate(
            day = 27,
            month = 6,
            year = 2000
        )
        Truth.assertThat(releaseDate.toString()).isEqualTo("27 de jun de 2000")
    }

    @Test
    fun `check throw exception`() {
        val releaseDate = ReleaseDate(
            day = 3,
            month = 14,
            year = 2012
        )
        try {
            releaseDate.toString()
            throw AssertionError("Not exception throws with invalid year")
        } catch (e: IllegalArgumentException) {

        }
    }
}