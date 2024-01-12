package com.example.lab_fragments.ui.movie.lab3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.lab_fragments.R
import com.example.lab_fragments.adapter.MovieAdapter
import com.example.lab_fragments.databinding.FragmentFirstBinding
import com.example.lab_fragments.domain.movie.model.Movie


class FirstFragment : Fragment(R.layout.fragment_first) {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var moviesViewModel: MoviesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFirstBinding.bind(view)

        val viewModelFactory = MoviesViewModelFactory(requireContext())
        moviesViewModel = ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]

        var adapter: MovieAdapter = MovieAdapter()
        binding.list.adapter = adapter

        //adapter.updateMovies(moviesViewModel.getMovieListApiLiveData().value!!)

        moviesViewModel.getMovieListApiLiveData().observe(viewLifecycleOwner) {
            adapter.updateMovies(it)
        }

        binding.button.setOnClickListener {
            moviesViewModel.search(binding.editQuery.text.toString())
        }

        adapter.setOnClickListener(object : MovieAdapter.OnClickListener{
            override fun onClick(model: Movie){
                val fragment = SecondFragment()
                val bundle = Bundle()
                bundle.putString("API", model.id)
                fragment.arguments = bundle
                parentFragmentManager.commit{
                    replace(R.id.fragmentContainerView, fragment)
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
            }
        })
    }
}