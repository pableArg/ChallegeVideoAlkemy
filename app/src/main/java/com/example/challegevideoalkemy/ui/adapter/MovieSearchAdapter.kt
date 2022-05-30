package com.example.challegevideoalkemy.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.challegevideoalkemy.R
import com.example.challegevideoalkemy.data.retrofit.Constants
import com.example.challegevideoalkemy.databinding.ItemCardBinding
import com.example.challegevideoalkemy.domain.model.Movie
import com.example.challegevideoalkemy.ui.fragments.HomeFragmentDirections
import com.example.challegevideoalkemy.ui.fragments.SearchFragmentDirections
import com.squareup.picasso.Picasso

class MovieSearchAdapter(
    var movieList: MutableList<Movie>) :
    RecyclerView.Adapter<MovieSearchViewHolder>() {

    override fun getItemCount(): Int = movieList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSearchViewHolder {
        val movieBinding =
            ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieSearchViewHolder(movieBinding)
    }

    override fun onBindViewHolder(holder: MovieSearchViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.txtTitle.text = movie.title
        Picasso.get()
            .load("${Constants.IMG_API_PATH}${movie.image}")
            .placeholder(R.color.purple_200)
            .into(holder.binding.imageView)

        holder.binding.imageView.setOnClickListener{
            /*var action=HomeFragmentDirections.actionHomeFragmentToDetailFragment(holder.binding.imageView.toString(),holder.binding.txtTitle.toString())
            findNavController().navigate(action)*/

            holder.binding.imageView.setOnClickListener { fabView ->
                fabView.findNavController().navigate(SearchFragmentDirections
                    .actionSearchFragment2ToDetailFragment(movie.title,movie.image,movie.descripcion,movie.lenguage,
                        movie.duration.toString(),movie.popularity,movie.premiere))


            }


        }

    }

}

class MovieSearchViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {


}