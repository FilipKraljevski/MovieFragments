package com.example.lab_fragments.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_fragments.domain.movie.model.Movie
import com.example.lab_fragments.domain.movie.repository.MovieFakeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val movieFakeRepository: MovieFakeRepository): ViewModel() {

    private val _movieDetail = MutableLiveData<Movie>()

    fun getMovieDetailLiveData(): LiveData<Movie> = _movieDetail

    fun setMovieDetail(query: String){
        viewModelScope.launch(Dispatchers.IO) {
            val movie = movieFakeRepository.getMovie(query)
            _movieDetail.postValue(movie)
        }
    }
}