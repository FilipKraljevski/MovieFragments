package com.example.lab_fragments.domain.movie.repository

import com.example.lab_fragments.domain.movie.RemoteMovieDataSource
import com.example.lab_fragments.domain.movie.model.ApiMovie
import com.example.lab_fragments.domain.movie.model.ApiMovieDetail

class MovieApiRepository(private val remoteMovieDataSource: RemoteMovieDataSource) {

    suspend fun queryMovies(query: String): List<ApiMovie>{
        return remoteMovieDataSource.search(query)
    }

    suspend fun queryMovieDetail(query: String): ApiMovieDetail{
        return remoteMovieDataSource.getDetail(query)
    }
}