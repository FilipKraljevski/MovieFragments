package com.example.lab_fragments.domain.movie.room

import androidx.room.*
import com.example.lab_fragments.domain.movie.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Delete()
    suspend fun deleteMovie(movie: Movie)

    @Query("DELETE FROM movie where id = :id")
    suspend fun delete(id: String)

    @Query("SELECT * FROM movie")
    suspend fun getAll(): List<Movie>

    @Query("SELECT * FROM movie WHERE id = :id")
    suspend fun findMovie(id: String): Movie
}
