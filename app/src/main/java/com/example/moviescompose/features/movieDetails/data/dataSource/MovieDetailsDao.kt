package com.example.moviescompose.features.movieDetails.data.dataSource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviescompose.features.movieDetails.data.dataSource.dto.DatabaseMovieDetailsDto
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDetailsDao {

    @Query("SELECT * from databasemoviedetailsdto")
    fun getAllMovieDetails(): Flow<List<DatabaseMovieDetailsDto>>

    @Query("SELECT * FROM databasemoviedetailsdto WHERE id = :id")
    suspend fun getNoteById(id: Int): DatabaseMovieDetailsDto?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetails(movieDetailsDto: DatabaseMovieDetailsDto)

    @Query("DELETE FROM databasemoviedetailsdto WHERE id = :movieId")
    suspend fun deleteMovieDetails(movieId: Int)
}