package com.example.moviescompose.features.movieDetails.data.dataSource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviescompose.features.movieDetails.data.dataSource.dto.EntityMovieDetailsDto
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDetailsDao {

    @Query("SELECT * from entitymoviedetailsdto")
    fun getAllMovieDetails(): Flow<List<EntityMovieDetailsDto>>

    @Query("SELECT * FROM entitymoviedetailsdto WHERE id = :id")
    suspend fun getMovieDetailsById(id: Int): EntityMovieDetailsDto?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetails(movieDetailsDto: EntityMovieDetailsDto)

    @Query("DELETE FROM entitymoviedetailsdto WHERE id = :movieId")
    suspend fun deleteMovieDetails(movieId: Int)
}