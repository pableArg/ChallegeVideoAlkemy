package com.example.challegevideoalkemy.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challegevideoalkemy.R
import com.example.challegevideoalkemy.data.retrofit.Constants
import com.example.challegevideoalkemy.databinding.ItemCardBinding
import com.example.challegevideoalkemy.domain.model.Movie
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

    }

}

class MovieSearchViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {


}