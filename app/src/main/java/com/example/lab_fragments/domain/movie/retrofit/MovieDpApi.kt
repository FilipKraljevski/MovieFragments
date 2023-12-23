package com.example.lab_fragments.domain.movie.retrofit

import com.example.lab_fragments.domain.movie.model.ApiMovieDetail
import com.example.lab_fragments.domain.movie.model.ApiMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDpApi {

    @GET("/")
    suspend fun searchMovies(@Query("s") s: String): Response<ApiMovieResponse>

    @GET("/")
    suspend fun getMovieDetail(@Query("i") s: String): Response<ApiMovieDetail>
}