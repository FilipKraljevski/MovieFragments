package com.example.lab_fragments.domain.movie

import com.example.lab_fragments.domain.movie.model.Movie

interface RemoteMovieDataSource {

    suspend fun search(query: String): Movie
}