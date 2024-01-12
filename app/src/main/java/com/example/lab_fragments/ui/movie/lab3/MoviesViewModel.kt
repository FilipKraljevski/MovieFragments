package com.example.lab_fragments.ui.movie.lab3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_fragments.domain.movie.model.Movie
import com.example.lab_fragments.domain.movie.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(private val movieRepository: MovieRepository): ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()

    fun getMovieListApiLiveData(): LiveData<List<Movie>> = _movies

    fun search(query: String){
        viewModelScope.launch(Dispatchers.IO) {
            val movies = movieRepository.queryMovies(query)
            _movies.postValue(movies)
        }
    }
}