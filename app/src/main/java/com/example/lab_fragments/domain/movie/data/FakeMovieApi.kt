package com.example.lab_fragments.domain.movie.data

import com.example.lab_fragments.domain.movie.model.Movie

class FakeMovieApi {

    private val movies: MutableList<Movie> = ArrayList()

    fun getAllMovies(): List<Movie>{
        return movies
    }

    fun addAll(movies: MutableList<Movie>){
        this.movies.addAll(movies)
    }

    fun addMovie(movie: Movie){
        movies.add(movie)
    }
}