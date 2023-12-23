package com.example.lab_fragments.ui.movie.remoteApi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_fragments.domain.movie.model.ApiMovie
import com.example.lab_fragments.domain.movie.repository.MovieApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApiMoviesViewModel(private val movieRepository: MovieApiRepository): ViewModel() {
    private val _moviesApi = MutableLiveData<List<ApiMovie>>()

    fun getMovieListApiLiveData(): LiveData<List<ApiMovie>> = _moviesApi

    fun search(query: String){
        viewModelScope.launch(Dispatchers.IO) {
            val movies = movieRepository.queryMovies(query)
            _moviesApi.postValue(movies)
        }
    }
}