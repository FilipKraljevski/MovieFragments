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

class ApiMovieAdapter(private val movies: ArrayList<ApiMovie> = ArrayList<ApiMovie>()): RecyclerView.Adapter<ApiMovieAdapter.MovieViewHolder>() {

    private var onClickListener: OnClickListener? = null

    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view){
        private var imageView: ImageView = view.findViewById(R.id.movie_image)
        private var titleText: TextView = view.findViewById(R.id.movie_title)
        private var idText: TextView = view.findViewById(R.id.movie_id)

        fun bind(movie: ApiMovie){
            Glide.with(imageView).load(movie.poster).centerCrop().placeholder(R.drawable.baseline_movie_creation_24)
                .into(imageView)
            titleText.text = movie.title
            idText.text = "ID: ${movie.id}"
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
        holder.itemView.setOnClickListener{
            if (onClickListener != null) {
                onClickListener!!.onClick(movies[position])
            }
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(model: ApiMovie)
    }

    fun updateMovies(newMovies: List<ApiMovie>){
        movies.clear()
        if(newMovies != null) {
            movies.addAll(newMovies)
        }
        notifyDataSetChanged()
    }
}