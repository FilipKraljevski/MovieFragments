package com.example.lab_fragments.domain.movie.model

import com.google.gson.annotations.SerializedName

data class ApiMovieResponse(@SerializedName("Search") val results: List<ApiMovie>, @SerializedName("Response") val response: String)