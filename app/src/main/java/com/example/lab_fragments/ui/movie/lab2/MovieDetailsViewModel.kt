package com.example.lab_fragments.ui.movie.lab2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_fragments.domain.movie.model.FakeMovie
import com.example.lab_fragments.domain.movie.repository.FakeMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val movieFakeRepository: FakeMovieRepository): ViewModel() {

    private val _movieDetail = MutableLiveData<FakeMovie>()

    fun getMovieDetailLiveData(): LiveData<FakeMovie> = _movieDetail

    fun setMovieDetail(query: String){
        viewModelScope.launch(Dispatchers.IO) {
            val movie = movieFakeRepository.getMovie(query)
            _movieDetail.postValue(movie)
        }
    }
}