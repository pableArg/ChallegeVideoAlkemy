package com.example.challegevideoalkemy.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.challegevideoalkemy.data.retrofit.MovieApiClientPopular
import com.example.challegevideoalkemy.domain.model.Movie
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel  (private val movieList: MovieApiClientPopular): ViewModel(){


    val movieListPopular = MutableLiveData<MutableList<Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun getMoviesPopular(): MutableLiveData<MutableList<Movie>> {
        return this.movieListPopular
    }

    class Factory() : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HomeViewModel(MovieApiClientPopular()) as T
        }
    }


    fun getMovie(page: Int) {
        viewModelScope.launch {
            try {
                val response = movieList.getPopularMovies(page)
                if (response.isSuccessful && response.body() != null) {
                    val movies = response.body()!!
                    if(movies.results != null) {
                        movieListPopular.value = movies.results
                    }else{
                        movieListPopular.value = mutableListOf()
                    }
                } else {
                    val error = response.errorBody().toString()
                    errorMessage.value = error
                }
            }catch (e: Exception){
                errorMessage.value = e.message
            }

        }
    }
    fun getMovies() {
        viewModelScope.launch {
            try {
                val response = movieList.getPopularMoviess()
                if (response.isSuccessful && response.body() != null) {
                    val movies = response.body()!!
                    if(movies.results != null) {
                        movieListPopular.value = movies.results
                    }else{
                        movieListPopular.value = mutableListOf()
                    }
                } else {
                    val error = response.errorBody().toString()
                    errorMessage.value = error
                }
            }catch (e: Exception){
                errorMessage.value = e.message
            }

        }
    }

//    fun getMovieAction() {
//        viewModelScope.launch {
//            val response = movieList.getPopularMoviess()
//            if (response.isSuccessful && response.body() != null) {
//                withContext(Dispatchers.Main) {
//                    moviesListDataAccion.value = response.body()
//                }
//            } else {
//                errorMessage.value = response.errorBody().toString()
//            }
//        }
//    }


}