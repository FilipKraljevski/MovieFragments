package com.example.lab_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.commit
import com.example.lab_fragments.dialog.AddNewMovieDialog
import com.example.lab_fragments.domain.movie.data.FakeMovieApiProvider
import com.example.lab_fragments.domain.movie.model.Movie
import com.example.lab_fragments.domain.movie.data.moviesList
import com.example.lab_fragments.domain.movie.repository.MovieFakeRepository
import com.example.lab_fragments.ui.movie.MovieListFragment

class MainActivity : AppCompatActivity(), AddNewMovieDialog.AddNewMovieDialogListener {

    private lateinit var repository: MovieFakeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = MovieFakeRepository(FakeMovieApiProvider.getFakeMovieApi())

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
        val movie = Movie(poster, title, id.toString(), plot, director, actors)
        repository.addMovie(movie)
        /*val fragment = MovieListFragment()
        val bundle = Bundle()
        bundle.putString("ID", id.toString())
        bundle.putString("poster", poster)
        bundle.putString("title", title)
        bundle.putString("plot", plot)
        bundle.putString("director", director)
        bundle.putString("actors", actors)
        fragment.arguments = bundle
        println(moviesList())*/
        supportFragmentManager.commit(){
            replace(R.id.fragmentContainerView,  MovieListFragment())
            setReorderingAllowed(true)
        }
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        dialog.dismiss()
    }
}