package com.example.challegevideoalkemy.data.retrofit

import com.example.challegevideoalkemy.domain.model.MovieResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApiClientTitle {

    private val getInstanceTitle: ApiService =
        Retrofit.Builder()
            .baseUrl(Constants.SEARCH_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    suspend fun getMoviesByTitle(title: String): Response<MovieResponse> {
        return getInstanceTitle.getMovie(title)
    }
}