package com.example.challegevideoalkemy.ui.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.challegevideoalkemy.data.retrofit.MovieById
import com.example.challegevideoalkemy.domain.model.MovieFavDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class DetailViewModel(private val moviesRepository: MovieById) : ViewModel(){

        val movieDetailsLiveData = MutableLiveData<MovieFavDetail>()
        val errorMessage = MutableLiveData<String>()


    /* fun getMovieDetailsById(movieId: Int) {
        viewModelScope.launch {
            try {
                val response = moviesRepository.getMovieByID(movieId)
                if (response.isSuccessful && response.body() != null) {
                    withContext(Dispatchers.IO) {
                        movieDetailsLiveData.value = response.body()
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

        fun movieIntoFavList(movieId: Int): Boolean {
            return favEntityRepository.movieIdIntoFavList(movieId)
        }

        fun addOrDeleteNewMovieFav(movieId: Int) {
            favEntityRepository.addOrDeleteNewMovieFav(movieId)
        }*/



}