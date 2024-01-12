package com.example.lab_fragments.ui.movie.lab2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_fragments.domain.movie.model.FakeMovie
import com.example.lab_fragments.domain.movie.repository.FakeMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel(private val movieFakeRepository: FakeMovieRepository): ViewModel() {
    private val _movies = MutableLiveData<List<FakeMovie>>()

    fun getMovieListLiveData(): LiveData<List<FakeMovie>> = _movies

    fun setMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            val movies = movieFakeRepository.getAllMovies()
            _movies.postValue(movies)
        }
    }
}