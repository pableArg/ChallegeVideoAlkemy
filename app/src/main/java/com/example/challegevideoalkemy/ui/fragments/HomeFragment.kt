package com.example.challegevideoalkemy.ui.fragments

import android.content.Intent
import android.os.Build.ID
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challegevideoalkemy.R
import com.example.challegevideoalkemy.databinding.FragmentHomeBinding
import com.example.challegevideoalkemy.domain.model.Movie
import com.example.challegevideoalkemy.ui.adapter.Communicator
import com.example.challegevideoalkemy.ui.adapter.MovieAdapter

import com.example.challegevideoalkemy.ui.viewModel.HomeViewModel


class HomeFragment : Fragment() {

    private lateinit var movieAdapter: MovieAdapter
    private val movieList = mutableListOf<Movie>()
    private lateinit var navControllerFragment : NavController
    private val model: HomeViewModel by viewModels() { HomeViewModel.Factory() }
    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var btnHome: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeBinding = FragmentHomeBinding.bind(view)
        getMovieData()
        initRecyclerView()
        setupObservers()


    }


    private fun initRecyclerView() {
        homeBinding.rv.layoutManager = GridLayoutManager(this.context, 2)
        movieAdapter = MovieAdapter(movieList)
        homeBinding.rv.adapter = movieAdapter

    }


    private fun getMovieData() {
        run {
            model.getMovies()
        }
    }

    private fun setupObservers() {
        model.getMoviesPopular().observe(viewLifecycleOwner) {
            movieAdapter.movieList = it
            movieAdapter.notifyDataSetChanged()
        }
    }






}




