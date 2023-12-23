package com.example.lab_fragments.ui.movie.remoteApi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.lab_fragments.R
import com.example.lab_fragments.adapter.ApiMovieAdapter
import com.example.lab_fragments.databinding.FragmentApiMovieListBinding
import com.example.lab_fragments.domain.movie.model.ApiMovie


class ApiMovieListFragment : Fragment(R.layout.fragment_api_movie_list) {

    private var _binding: FragmentApiMovieListBinding? = null
    private val binding get() = _binding!!

    private lateinit var moviesViewModel: ApiMoviesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentApiMovieListBinding.bind(view)

        val viewModelFactory = ApiMoviesViewModelFactory(requireContext())
        moviesViewModel = ViewModelProvider(this, viewModelFactory)[ApiMoviesViewModel::class.java]

        var adapter: ApiMovieAdapter = ApiMovieAdapter()
        binding.list.adapter = adapter

        moviesViewModel.getMovieListApiLiveData().observe(viewLifecycleOwner) {
            adapter.updateMovies(it)
        }

        binding.button.setOnClickListener {
            moviesViewModel.search(binding.editQuery.text.toString())
        }

        adapter.setOnClickListener(object : ApiMovieAdapter.OnClickListener{
            override fun onClick(model: ApiMovie ){
                val fragment = ApiMovieDetailsFragment()
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