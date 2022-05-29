package com.example.challegevideoalkemy.data.retrofit
import com.example.challegevideoalkemy.data.retrofit.Constants.Companion.API_KEY
import com.example.challegevideoalkemy.data.retrofit.Constants.Companion.LANGUAGE_SPANISH
import com.example.challegevideoalkemy.domain.model.Movie
import com.example.challegevideoalkemy.domain.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("{movie_id}?api_key=${API_KEY}&${LANGUAGE_SPANISH}")
    suspend fun getMovieByID(@Path("movie_id") id: Int): Response<Movie>

    @GET("movie?api_key=$API_KEY&query=movie&$LANGUAGE_SPANISH")
    suspend fun getMovie(@Query("query") title: String): Response<MovieResponse>

    @GET ("movie/popular?api_key=18bde2ea565d886a8a0c64ff46bee127")
    suspend fun getMoviePopular(): Response <MovieResponse>

}
