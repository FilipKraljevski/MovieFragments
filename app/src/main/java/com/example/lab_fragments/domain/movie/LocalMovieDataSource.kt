package com.example.lab_fragments.domain.movie

import com.example.lab_fragments.domain.movie.model.Movie

interface LocalMovieDataSource {
    suspend fun insertMovie(movie: Movie)

    suspend fun saveAll(movies: List<Movie>)

    suspend fun delete(id: String)

    suspend fun getAll(): List<Movie>

    suspend fun findMovie(id: String): Movie
}