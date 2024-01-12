package com.example.lab_fragments.domain.movie.data

import com.example.lab_fragments.domain.movie.model.FakeMovie

class FakeMovieApi {

    private val movies: MutableList<FakeMovie> = ArrayList()

    fun getAllMovies(): List<FakeMovie>{
        return movies
    }

    fun addAll(movies: MutableList<FakeMovie>){
        this.movies.addAll(movies)
    }

    fun addMovie(movie: FakeMovie){
        movies.add(movie)
    }
}