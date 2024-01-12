package com.example.lab_fragments.ui.movie.lab3

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab_fragments.domain.movie.repository.MovieRepository
import com.example.lab_fragments.domain.movie.retrofit.MovieDpApiProvider
import com.example.lab_fragments.domain.movie.retrofit.RetrofitMovieDataSource
import com.example.lab_fragments.domain.movie.room.AppDatabase
import com.example.lab_fragments.domain.movie.room.RoomMovieDataSource
import com.example.lab_fragments.utils.NetworkConnectivity

class MoviesViewModelFactory (private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java)
            .newInstance(MovieRepository(RetrofitMovieDataSource(MovieDpApiProvider.getMovieDbApi()),
                RoomMovieDataSource(AppDatabase.getDatabase(context).movieDao()),
                NetworkConnectivity(context)
            ))
    }
}