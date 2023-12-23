package com.example.lab_fragments.domain.movie.model

import com.google.gson.annotations.SerializedName

data class ApiMovie(@SerializedName("Poster") val poster: String, @SerializedName("Title") val title: String,
                    @SerializedName("imdbID") val id: String)