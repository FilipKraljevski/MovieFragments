package com.example.lab_fragments.domain.movie.retrofit

import com.example.lab_fragments.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class MovieDpApiProvider {

    companion object {
        @Volatile
        private var INSTANCE: MovieDpApi? = null

        @JvmStatic
        fun getMovieDbApi(): MovieDpApi {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = createMovieDbApi()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private fun createMovieDbApi(): MovieDpApi {
            class QueryParamInterceptor : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response {
                    var request: Request = chain.request()
                    val htt = request.url.newBuilder()
                        .addQueryParameter("apikey", BuildConfig.MOVIE_DB_API_KEY)
                        .addQueryParameter("type", "movie")
                        .build()
                    request = request.newBuilder().url(htt).build()
                    return chain.proceed(request)
                }
            }

            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val okhttpClient = OkHttpClient.Builder()
                .addInterceptor(QueryParamInterceptor())
                .addInterceptor(httpLoggingInterceptor)
                .build()
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val gsonConverterFactory = GsonConverterFactory.create(gson)

            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.omdbapi.com")
                .client(okhttpClient)
                .addConverterFactory(gsonConverterFactory)
                .build()
            return retrofit.create(MovieDpApi::class.java)
        }
    }
}