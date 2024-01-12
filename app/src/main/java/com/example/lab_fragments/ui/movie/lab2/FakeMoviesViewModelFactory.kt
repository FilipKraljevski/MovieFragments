package com.example.lab_fragments.ui.movie.lab2

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab_fragments.domain.movie.data.FakeMovieApiProvider
import com.example.lab_fragments.domain.movie.repository.FakeMovieRepository

class FakeMoviesViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(FakeMovieRepository::class.java)
            .newInstance(FakeMovieRepository(FakeMovieApiProvider.getFakeMovieApi()))
    }
}