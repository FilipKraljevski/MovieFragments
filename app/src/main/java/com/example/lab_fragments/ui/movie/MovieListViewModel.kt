package com.example.lab_fragments.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_fragments.domain.movie.model.Movie
import com.example.lab_fragments.domain.movie.repository.MovieFakeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel(private val movieFakeRepository: MovieFakeRepository): ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()

    fun getMovieListLiveData(): LiveData<List<Movie>> = _movies

    fun setMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            val movies = movieFakeRepository.getAllMovies()
            _movies.postValue(movies)
        }
    }
}