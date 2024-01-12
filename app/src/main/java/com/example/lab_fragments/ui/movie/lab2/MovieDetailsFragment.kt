package com.example.lab_fragments.ui.movie.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.lab_fragments.R
import com.example.lab_fragments.databinding.FragmentMovieDetailsBinding

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var movieDetailsViewModel: MovieDetailsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieDetailsBinding.bind(view)

        val viewModelFactory = FakeMoviesViewModelFactory(requireContext())
        movieDetailsViewModel = ViewModelProvider(this, viewModelFactory)[MovieDetailsViewModel::class.java]

        val bundle = this.arguments
        if (bundle != null) {
            val id = bundle.getString("ID").toString()
            movieDetailsViewModel.setMovieDetail(id)
            println(id)
        }

        movieDetailsViewModel.getMovieDetailLiveData().observe(viewLifecycleOwner){
            Glide.with(binding.movieImage).load(movieDetailsViewModel.getMovieDetailLiveData().value?.poster)
                .centerCrop().placeholder(R.drawable.baseline_movie_creation_24).into(binding.movieImage)
            binding.movieTitle.text = "Title: ${movieDetailsViewModel.getMovieDetailLiveData().value?.title}"
            binding.movieId.text = "ID: ${movieDetailsViewModel.getMovieDetailLiveData().value?.id}"
            binding.movieDescription.text = "Plot: ${movieDetailsViewModel.getMovieDetailLiveData().value?.plot}"
            binding.movieDirector.text = "Director: ${movieDetailsViewModel.getMovieDetailLiveData().value?.director}"
            binding.movieActors.text = "Actors: ${movieDetailsViewModel.getMovieDetailLiveData().value?.actors}"
        }
    }
}