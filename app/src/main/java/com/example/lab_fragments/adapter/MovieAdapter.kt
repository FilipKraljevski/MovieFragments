package com.example.lab_fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_fragments.R
import com.example.lab_fragments.domain.movie.model.ApiMovie
import com.example.lab_fragments.domain.movie.model.Movie

class MovieAdapter(private val movies: ArrayList<Movie> = ArrayList<Movie>()): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    private var onClickListener: OnClickListener? = null

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var imageView: ImageView = view.findViewById(R.id.movie_image)
        private var titleText: TextView = view.findViewById(R.id.movie_title)
        private var idText: TextView = view.findViewById(R.id.movie_id)
        private var directorText: TextView = view.findViewById(R.id.movie_director)

        fun bind(movie: Movie) {
            Glide.with(imageView).load(movie.poster).centerCrop()
                .placeholder(R.drawable.baseline_movie_creation_24)
                .into(imageView)
            titleText.text = movie.title
            idText.text = "ID: ${movie.id}"
            directorText.text = "Director: ${movie.director}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(movies[position])
            }
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(model: Movie)
    }

    fun updateMovies(newMovies: List<Movie>) {
        movies.clear()
        movies.addAll(newMovies)
        notifyDataSetChanged()
    }
}