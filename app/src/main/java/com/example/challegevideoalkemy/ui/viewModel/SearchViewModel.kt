package com.example.challegevideoalkemy.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.challegevideoalkemy.data.retrofit.MovieApiClientTitle
import com.example.challegevideoalkemy.domain.model.Movie
import com.example.challegevideoalkemy.domain.model.MovieResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchViewModel(private val movieList: MovieApiClientTitle) : ViewModel() {
    private val movie = MutableLiveData<MutableList<Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun getSearchedMovie(): MutableLiveData<MutableList<Movie>> {
        return this.movie
    }

    class Factory() : ViewModelProvider.NewInstanceFactory() {
        // Disclaimer esto es medio termidor
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SearchViewModel(MovieApiClientTitle()) as T
        }
    }


    fun getMovies(query: String) {
        viewModelScope.launch {
            try {
                val response = movieList.getMoviesByTitle(query)
                if (response.isSuccessful && response.body() != null) {
                    val books = response.body()!!
                    if (books.results != null) {
                        movie.value = books.results
                    } else {
                        movie.value = mutableListOf()
                    }
                } else {
                    val error = response.errorBody().toString()
                    errorMessage.value = error
                }
            } catch (e: Exception) {
                errorMessage.value = e.message
            }

        }
    }
}
