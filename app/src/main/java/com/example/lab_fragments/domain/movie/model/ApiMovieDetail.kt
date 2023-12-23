package com.example.lab_fragments.domain.movie.model

import com.google.gson.annotations.SerializedName

data class ApiMovieDetail(@SerializedName("Poster") val poster: String, @SerializedName("Title") val title: String,
                          @SerializedName("imdbID") val id: String, @SerializedName("Plot") val plot: String,
                          @SerializedName("Director") val director: String, @SerializedName("Actors") val actors: String)