package com.example.lab_fragments.domain.movie.retrofit

import com.example.lab_fragments.domain.movie.RemoteMovieDataSource
import com.example.lab_fragments.domain.movie.model.ApiMovie
import com.example.lab_fragments.domain.movie.model.ApiMovieDetail


class RetrofitMovieDataSource(private val movieDpApi: MovieDpApi): RemoteMovieDataSource {
    override suspend fun search(query: String): List<ApiMovie> {
        val movieResponse = movieDpApi.searchMovies(query)
        val responseBody = movieResponse.body()
        if(movieResponse.isSuccessful && responseBody != null && responseBody.response == "True"){
            return responseBody.results
        }
        return emptyArray<ApiMovie>().toList()
        //throw Exception("Error searching movies.")
    }

    override suspend fun getDetail(query: String): ApiMovieDetail {
        val movieResponse = movieDpApi.getMovieDetail(query)
        val responseBody = movieResponse.body()
        if(movieResponse.isSuccessful && responseBody != null){
            return responseBody
        }
        throw Exception("Error searching movies.")
    }
}