package com.example.lab_fragments.ui.movie

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab_fragments.domain.movie.data.FakeMovieApi
import com.example.lab_fragments.domain.movie.data.FakeMovieApiProvider
import com.example.lab_fragments.domain.movie.repository.MovieApiRepository
import com.example.lab_fragments.domain.movie.repository.MovieFakeRepository
import com.example.lab_fragments.domain.movie.retrofit.MovieDpApiProvider
import com.example.lab_fragments.domain.movie.retrofit.RetrofitMovieDataSource

class MoviesViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieFakeRepository::class.java)
            .newInstance(MovieFakeRepository(FakeMovieApiProvider.getFakeMovieApi()))
    }
}