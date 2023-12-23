package com.example.lab_fragments.ui.movie.remoteApi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.lab_fragments.R
import com.example.lab_fragments.databinding.FragmentApiMovieDetailsBinding


class ApiMovieDetailsFragment : Fragment(R.layout.fragment_api_movie_details) {

    private var _binding: FragmentApiMovieDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var movieDetailsViewModel: ApiMovieDetailsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentApiMovieDetailsBinding.bind(view)

        val viewModelFactory = ApiMoviesViewModelFactory(requireContext())
        movieDetailsViewModel = ViewModelProvider(this, viewModelFactory)[ApiMovieDetailsViewModel::class.java]

        val bundle = this.arguments
        if (bundle != null) {
            val id = bundle.getString("API").toString()
            movieDetailsViewModel.setApiMovieDetail(id)
        }

        movieDetailsViewModel.getMovieDetailApiLiveData().observe(viewLifecycleOwner){
            Glide.with(binding.movieImage).load(movieDetailsViewModel.getMovieDetailApiLiveData().value?.poster)
                .centerCrop().placeholder(R.drawable.baseline_movie_creation_24).into(binding.movieImage)
            binding.movieTitle.text = "Title: ${movieDetailsViewModel.getMovieDetailApiLiveData().value?.title}"
            binding.movieId.text = "ID: ${movieDetailsViewModel.getMovieDetailApiLiveData().value?.id}"
            binding.movieDescription.text = "Plot: ${movieDetailsViewModel.getMovieDetailApiLiveData().value?.plot}"
            binding.movieDirector.text = "Director: ${movieDetailsViewModel.getMovieDetailApiLiveData().value?.director}"
            binding.movieActors.text = "Actors: ${movieDetailsViewModel.getMovieDetailApiLiveData().value?.actors}"
        }
    }
}