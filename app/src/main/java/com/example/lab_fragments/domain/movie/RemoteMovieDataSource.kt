package com.example.lab_fragments.domain.movie

import com.example.lab_fragments.domain.movie.model.ApiMovie
import com.example.lab_fragments.domain.movie.model.ApiMovieDetail

interface RemoteMovieDataSource {
    suspend fun search(query:String): List<ApiMovie>

    suspend fun getDetail(query: String): ApiMovieDetail
}