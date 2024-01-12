package com.example.lab_fragments.ui.movie.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.lab_fragments.R
import com.example.lab_fragments.adapter.FakeMovieAdapter
import com.example.lab_fragments.databinding.FragmentMovieListBinding
import com.example.lab_fragments.dialog.AddNewMovieDialog
import com.example.lab_fragments.domain.movie.model.FakeMovie
import com.example.lab_fragments.ui.movie.lab3.FirstFragment

class MovieListFragment : Fragment(R.layout.fragment_movie_list) {
    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    private lateinit var moviesViewModel: MovieListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieListBinding.bind(view)

        val viewModelFactory = FakeMoviesViewModelFactory(requireContext())
        moviesViewModel = ViewModelProvider(this, viewModelFactory)[MovieListViewModel::class.java]

        var adapter: FakeMovieAdapter = FakeMovieAdapter()
        binding.list.adapter = adapter

        moviesViewModel.getMovieListLiveData().observe(viewLifecycleOwner) {
            adapter.updateMovies(it)
        }

        moviesViewModel.setMovies()

        adapter.setOnClickListener(object : FakeMovieAdapter.OnClickListener {
            override fun onClick(model: FakeMovie) {
                val fragment = MovieDetailsFragment()
                val bundle = Bundle()
                bundle.putString("ID", model.id)
                fragment.arguments = bundle
                parentFragmentManager.commit {
                    replace(R.id.fragmentContainerView, fragment)
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
            }
        })

        binding.addNewMovieDialog.setOnClickListener {
            val dialog = AddNewMovieDialog()
            dialog.show(childFragmentManager, "AddNewMovieDialog")
        }

        binding.btnGoToApiMovieList.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragmentContainerView, FirstFragment())
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }
    }
}