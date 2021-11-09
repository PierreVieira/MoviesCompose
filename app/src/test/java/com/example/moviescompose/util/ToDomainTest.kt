package com.example.moviescompose.util

import com.example.moviescompose.features.home.domain.model.ReleaseDate
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ToDomainTest {

    private val releaseDateExpected: ReleaseDate = ReleaseDate(
        day = 28,
        month = 10,
        year = 1990
    )

    private val releaseDateResult = ToDomain.toReleaseDate(releaseDate = "1990-10-28")

    @Test
    fun `to release date (day)`() {
        assertThat(releaseDateResult.day).isEqualTo(releaseDateExpected.day)
    }

    @Test
    fun `to release date (month)`() {
        assertThat(releaseDateResult.month).isEqualTo(releaseDateExpected.month)
    }

    @Test
    fun `to release date (year)`() {
        assertThat(releaseDateResult.year).isEqualTo(releaseDateExpected.year)
    }
}