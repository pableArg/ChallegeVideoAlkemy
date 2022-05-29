package com.example.challegevideoalkemy.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.ThemedSpinnerAdapter
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challegevideoalkemy.R
import com.example.challegevideoalkemy.databinding.FragmentSearchBinding
import com.example.challegevideoalkemy.domain.model.Movie
import com.example.challegevideoalkemy.ui.adapter.MovieAdapter
import com.example.challegevideoalkemy.ui.adapter.MovieSearchAdapter
import com.example.challegevideoalkemy.ui.viewModel.SearchViewModel
import com.example.challegevideoalkemy.utils.hideKeyboard


class SearchFragment : Fragment() {
    private lateinit var movieSearchAdapter: MovieSearchAdapter
    private lateinit var searchBinding: FragmentSearchBinding
    private var movieList = mutableListOf<Movie>()
    private val model: SearchViewModel by activityViewModels() { SearchViewModel.Factory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        searchBinding = FragmentSearchBinding.bind(view)
        setSearchViewListener()
        initRecyclerView()
        setupObservers()
    }


    private fun setSearchViewListener() {
        searchBinding.sv.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.run {
                        model.getMoviesByTitle(this)
                    }
                    hideKeyboard()
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
    }

    private fun initRecyclerView() {
        searchBinding.rv.layoutManager = GridLayoutManager(this.context, 2)
        movieSearchAdapter = MovieSearchAdapter(movieList)
        searchBinding.rv.adapter = movieSearchAdapter

    }

    private fun setupObservers() {
        model.getSearchedMovie().observe(viewLifecycleOwner) {
            movieSearchAdapter.movieList = it
            movieSearchAdapter.notifyDataSetChanged()
        }
    }


}
