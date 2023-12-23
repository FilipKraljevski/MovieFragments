package com.example.lab_fragments.ui.movie.remoteApi

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab_fragments.domain.movie.repository.MovieApiRepository
import com.example.lab_fragments.domain.movie.retrofit.MovieDpApiProvider
import com.example.lab_fragments.domain.movie.retrofit.RetrofitMovieDataSource

class ApiMoviesViewModelFactory (private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieApiRepository::class.java)
            .newInstance(MovieApiRepository(RetrofitMovieDataSource(MovieDpApiProvider.getMovieDbApi())))
    }
}