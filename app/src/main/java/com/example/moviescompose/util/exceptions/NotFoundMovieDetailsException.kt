package com.example.moviescompose.util.exceptions

class NotFoundMovieDetailsException(override val message: String = "Not found movie details in database") :
    NullPointerException()