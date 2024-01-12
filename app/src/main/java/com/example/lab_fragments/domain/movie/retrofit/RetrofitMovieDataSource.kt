package com.example.lab_fragments.domain.movie.retrofit

import com.example.lab_fragments.domain.movie.RemoteMovieDataSource
import com.example.lab_fragments.domain.movie.model.Movie


class RetrofitMovieDataSource(private val movieDpApi: MovieDpApi): RemoteMovieDataSource {
    override suspend fun search(query: String): Movie {
        val movieResponse = movieDpApi.getMovie(query)
        val responseBody = movieResponse.body()
        if(movieResponse.isSuccessful && responseBody != null && responseBody.response == "True"){
            return Movie(responseBody.id, responseBody.poster, responseBody.title, responseBody.plot,
                responseBody.director, responseBody.actors, responseBody.year)
        }
        throw Exception("Error searching movies.")
    }
}