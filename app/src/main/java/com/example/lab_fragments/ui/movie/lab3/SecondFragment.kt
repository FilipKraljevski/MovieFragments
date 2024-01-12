package com.example.lab_fragments.ui.movie.lab3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.lab_fragments.R
import com.example.lab_fragments.databinding.FragmentSecondBinding


class SecondFragment : Fragment(R.layout.fragment_second) {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private lateinit var movieDetailsViewModel: MovieDetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSecondBinding.bind(view)

        val viewModelFactory = MoviesViewModelFactory(requireContext())
        movieDetailsViewModel = ViewModelProvider(this, viewModelFactory)[MovieDetailViewModel::class.java]

        val bundle = this.arguments
        if (bundle != null) {
            val id = bundle.getString("API").toString()
            movieDetailsViewModel.findMovie(id)
        }

        movieDetailsViewModel.getMovieDetailLiveData().observe(viewLifecycleOwner){
            Glide.with(binding.movieImage).load(movieDetailsViewModel.getMovieDetailLiveData().value?.poster)
                .centerCrop().placeholder(R.drawable.baseline_movie_creation_24).into(binding.movieImage)
            binding.movieTitle.text = "Title: ${movieDetailsViewModel.getMovieDetailLiveData().value?.title}"
            binding.movieYear.text = "Year: ${movieDetailsViewModel.getMovieDetailLiveData().value?.year}"
            binding.movieDescription.text = "Plot: ${movieDetailsViewModel.getMovieDetailLiveData().value?.plot}"
            binding.movieDirector.text = "Director: ${movieDetailsViewModel.getMovieDetailLiveData().value?.director}"
            binding.movieActors.text = "Actors: ${movieDetailsViewModel.getMovieDetailLiveData().value?.actors}"
        }
    }
}