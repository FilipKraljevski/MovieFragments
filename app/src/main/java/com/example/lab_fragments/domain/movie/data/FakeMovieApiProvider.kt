package com.example.lab_fragments.domain.movie.data

class FakeMovieApiProvider {

    companion object {
        @Volatile
        private var INSTANCE: FakeMovieApi? = null

        @JvmStatic
        fun getFakeMovieApi(): FakeMovieApi {
            return INSTANCE ?: synchronized(this) {
                val instance = FakeMovieApiProvider.createFakeMovieApi()
                INSTANCE = instance
                instance
            }
        }

        private fun createFakeMovieApi(): FakeMovieApi {
            val movies = FakeMovieApi()
            movies.addAll(moviesList())
            return movies
        }
    }
}