package com.example.lab_fragments.ui.movie.remoteApi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_fragments.domain.movie.model.ApiMovieDetail
import com.example.lab_fragments.domain.movie.repository.MovieApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApiMovieDetailsViewModel(private val movieRepository: MovieApiRepository): ViewModel() {

    private val _movieDetailApi = MutableLiveData<ApiMovieDetail>()

    fun getMovieDetailApiLiveData(): LiveData<ApiMovieDetail> = _movieDetailApi

    fun setApiMovieDetail(query: String){
        viewModelScope.launch(Dispatchers.IO) {
            val movie = movieRepository.queryMovieDetail(query)
            _movieDetailApi.postValue(movie)
        }
    }
}