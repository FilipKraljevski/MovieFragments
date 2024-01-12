package com.example.lab_fragments.domain.movie.room

import com.example.lab_fragments.domain.movie.LocalMovieDataSource
import com.example.lab_fragments.domain.movie.model.Movie

class RoomMovieDataSource(private val movieDao: MovieDao): LocalMovieDataSource {
    override suspend fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie)
    }
    override suspend fun saveAll(movies: List<Movie>) {
        for (movie in movies) {
            movieDao.insertMovie(movie)
        }
    }
    override suspend fun delete(id: String) {
        movieDao.delete(id)
    }
    override suspend fun getAll(): List<Movie> {
        return movieDao.getAll()
    }
    override suspend fun findMovie(id: String): Movie {
        return movieDao.findMovie(id)
    }

}