package com.example.moviescompose.features.movieDetails.data.dataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviescompose.features.movieDetails.data.dataSource.dto.EntityMovieDetailsDto
import com.example.moviescompose.util.Converters

@Database(
    entities = [EntityMovieDetailsDto::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MovieDetailsDatabase: RoomDatabase() {

    abstract val movieDetailsDao: MovieDetailsDao

    companion object {
        const val DATABASE_NAME = "movie_details_db"
    }
}