package com.example.lab_fragments.domain.movie.repository

import com.example.lab_fragments.domain.movie.data.FakeMovieApi
import com.example.lab_fragments.domain.movie.model.Movie
import com.example.lab_fragments.domain.movie.data.moviesList

class MovieFakeRepository(private val fakeMovieApi: FakeMovieApi) {

    fun getAllMovies(): List<Movie>{
        return fakeMovieApi.getAllMovies()
    }

    fun addMovie(movie: Movie){
       fakeMovieApi.addMovie(movie)
    }

    fun getMovie(id: String): Movie{
        return fakeMovieApi.getAllMovies().find { m -> m.id == id}!!
    }
}