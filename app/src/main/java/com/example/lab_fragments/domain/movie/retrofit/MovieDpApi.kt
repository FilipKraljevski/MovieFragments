package com.example.lab_fragments.domain.movie.retrofit

import com.example.lab_fragments.domain.movie.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDpApi {

    @GET("/")
    suspend fun getMovie(@Query("t") s: String): Response<MovieResponse>
}