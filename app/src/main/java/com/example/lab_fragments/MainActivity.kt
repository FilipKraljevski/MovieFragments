package com.example.lab_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.commit
import com.example.lab_fragments.dialog.AddNewMovieDialog
import com.example.lab_fragments.domain.movie.data.FakeMovieApiProvider
import com.example.lab_fragments.domain.movie.model.FakeMovie
import com.example.lab_fragments.domain.movie.data.moviesList
import com.example.lab_fragments.domain.movie.repository.FakeMovieRepository
import com.example.lab_fragments.ui.movie.lab2.MovieListFragment

class MainActivity : AppCompatActivity(), AddNewMovieDialog.AddNewMovieDialogListener {

    private lateinit var repository: FakeMovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = FakeMovieRepository(FakeMovieApiProvider.getFakeMovieApi())

        if(savedInstanceState == null){
            supportFragmentManager.commit {
                add(R.id.fragmentContainerView, MovieListFragment())
                setReorderingAllowed(true)
            }
        }
    }

    override fun onDialogPositiveClick(
        title: String,
        plot: String,
        director: String,
        actors: String,
        poster: String
    ) {
        val id = moviesList().size + 1;
        val movie = FakeMovie(poster, title, id.toString(), plot, director, actors)
        repository.addMovie(movie)
        supportFragmentManager.commit(){
            replace(R.id.fragmentContainerView,  MovieListFragment())
            setReorderingAllowed(true)
        }
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        dialog.dismiss()
    }
}