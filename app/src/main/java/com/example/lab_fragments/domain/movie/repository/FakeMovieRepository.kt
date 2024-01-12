package com.example.lab_fragments.domain.movie.repository

import com.example.lab_fragments.domain.movie.data.FakeMovieApi
import com.example.lab_fragments.domain.movie.model.FakeMovie

class FakeMovieRepository(private val fakeMovieApi: FakeMovieApi) {

    fun getAllMovies(): List<FakeMovie>{
        return fakeMovieApi.getAllMovies()
    }

    fun addMovie(movie: FakeMovie){
       fakeMovieApi.addMovie(movie)
    }

    fun getMovie(id: String): FakeMovie{
        return fakeMovieApi.getAllMovies().find { m -> m.id == id}!!
    }
}