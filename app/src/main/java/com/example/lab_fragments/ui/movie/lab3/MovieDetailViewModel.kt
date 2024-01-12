package com.example.lab_fragments.ui.movie.lab3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_fragments.domain.movie.model.Movie
import com.example.lab_fragments.domain.movie.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailViewModel(private val movieRepository: MovieRepository): ViewModel() {

    private val _movieDetail = MutableLiveData<Movie>()

    fun getMovieDetailLiveData(): LiveData<Movie> = _movieDetail

    fun findMovie(id: String){
        viewModelScope.launch(Dispatchers.IO) {
            val movie = movieRepository.findMovie(id)
            _movieDetail.postValue(movie)
        }
    }
}