package com.example.challegevideoalkemy.data.retrofit

import com.example.challegevideoalkemy.data.retrofit.Constants.Companion.BASE_URL
import com.example.challegevideoalkemy.domain.model.MovieResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApiClientPopular {
            private val getInstance =
                Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(ApiService::class.java)




        suspend fun getPopularMoviess(): Response<MovieResponse> {
            return getInstance.getMoviePopular()
        }
    }


