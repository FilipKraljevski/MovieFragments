package com.example.lab_fragments.domain.movie.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(@PrimaryKey(autoGenerate = false) val id: String, val poster: String, val title: String, val plot: String,
                 val director: String, val actors: String, val year: String)