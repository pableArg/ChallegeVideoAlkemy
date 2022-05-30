package com.example.challegevideoalkemy.ui.adapter


import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController

import androidx.recyclerview.widget.RecyclerView
import com.example.challegevideoalkemy.R
import com.example.challegevideoalkemy.data.retrofit.Constants.Companion.IMG_API_PATH
import com.example.challegevideoalkemy.databinding.ItemCardBinding
import com.example.challegevideoalkemy.domain.model.Movie
import com.example.challegevideoalkemy.ui.fragments.*

import com.squareup.picasso.Picasso

class MovieAdapter(
    var movieList: MutableList<Movie>,
) :
    RecyclerView.Adapter<MovieAdapter.MyMovieViewHolder>() {


    override fun getItemCount(): Int = movieList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMovieViewHolder {
        val movieBinding =
            ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyMovieViewHolder(movieBinding)
    }

    override fun onBindViewHolder(holder: MyMovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.txtTitle.text = movie.title
        Picasso.get()
            .load("${IMG_API_PATH}${movie.image}")
            .placeholder(R.color.purple_200)
            .into(holder.binding.imageView)

        holder.binding.imageView.setOnClickListener{
            /*var action=HomeFragmentDirections.actionHomeFragmentToDetailFragment(holder.binding.imageView.toString(),holder.binding.txtTitle.toString())
            findNavController().navigate(action)*/

            holder.binding.imageView.setOnClickListener { fabView ->
                fabView.findNavController().navigate(HomeFragmentDirections
                    .actionHomeFragmentToDetailFragment(movie.title,movie.image,movie.descripcion,movie.lenguage,
                        movie.duration.toString(),movie.popularity,movie.premiere))


            }


        }


    }

    class MyMovieViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root)


}





