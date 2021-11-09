package com.example.moviescompose.features.movieDetails.domain.useCase

import com.example.moviescompose.features.data.repository.FakeMovieDetailsRepository
import com.example.moviescompose.features.data.repository.FakeMovieDetailsRepository.Companion.FAKE_MOVIE_ID_FROM_DATABASE
import com.example.moviescompose.features.data.repository.FakeMovieDetailsRepository.Companion.FAKE_MOVIE_ID_FROM_WEB
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetMovieDetailsTest {
    private lateinit var getMovieDetails: GetMovieDetails
    private val fakeMovieDetailsRepository = FakeMovieDetailsRepository()

    @Before
    fun setUp() {
        getMovieDetails = GetMovieDetails(
            repository = fakeMovieDetailsRepository,
            getMovieVideos = GetMovieVideo(repository = fakeMovieDetailsRepository)
        )
    }

    @Test
    fun `get from database first`() = assertGetData(FAKE_MOVIE_ID_FROM_DATABASE)

    @Test
    fun `get from web if not find in database`() = assertGetData(FAKE_MOVIE_ID_FROM_WEB)

    private fun assertGetData(id: Int) = runBlocking {
        val result = getMovieDetails(id).last()
        result.data.let { movieDetails ->
            assertThat(movieDetails?.id).isEqualTo(id)
        }
    }
}