package com.example.challegevideoalkemy.data.retrofit

import com.example.challegevideoalkemy.domain.model.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieById {

    private val serviceGetMovieByID: ApiService = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/movie/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    suspend fun getMovieByID(movieID: Int): Response<Movie> {
        return serviceGetMovieByID.getMovieByID(movieID)
    }
}