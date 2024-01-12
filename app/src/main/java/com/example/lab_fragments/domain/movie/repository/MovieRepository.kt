package com.example.lab_fragments.domain.movie.repository

import com.example.lab_fragments.domain.movie.LocalMovieDataSource
import com.example.lab_fragments.domain.movie.RemoteMovieDataSource
import com.example.lab_fragments.domain.movie.model.Movie
import com.example.lab_fragments.utils.NetworkConnectivity

class MovieRepository(private val remoteMovieDataSource: RemoteMovieDataSource,
                      private val localMovieDataSource: LocalMovieDataSource,
                      private val networkConnectivity: NetworkConnectivity
) {

    suspend fun queryMovies(query: String): List<Movie>{
        try {
            if (networkConnectivity.isNetworkAvailable) {
                remoteMovieDataSource.search(query).apply { localMovieDataSource.insertMovie(this) }
            }
        }catch (exception: Exception){
            return localMovieDataSource.getAll();
        }
        return localMovieDataSource.getAll();
    }

    suspend fun findMovie(id: String): Movie{
        return localMovieDataSource.findMovie(id)
    }
}