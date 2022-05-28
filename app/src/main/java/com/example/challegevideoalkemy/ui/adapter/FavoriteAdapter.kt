package com.example.challegevideoalkemy.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challegevideoalkemy.R
import com.example.challegevideoalkemy.data.retrofit.Constants
import com.example.challegevideoalkemy.databinding.ItemFavoriteBinding
import com.example.challegevideoalkemy.domain.model.MovieFavDetail
import com.squareup.picasso.Picasso


class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.MyFavoriteViewHolder>() {
    private var favoritesMovies = mutableListOf<MovieFavDetail>()
    private lateinit var onClickMaterialCardView: OnClickMaterialCardView


    override fun getItemCount(): Int = favoritesMovies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFavoriteViewHolder {
        return FavoriteAdapter.MyFavoriteViewHolder(
            ItemFavoriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyFavoriteViewHolder, position: Int) {
        val favoriteMovie = favoritesMovies[position]

        holder.binding.txtTitleFavorite.text = favoriteMovie.title

        Picasso.get()
            .load("${Constants.IMG_API_PATH}${favoriteMovie.image}")
            .placeholder(R.color.purple_200)
            .into(holder.binding.imageViewFavorite)

        holder.binding.cardView.setOnClickListener {
            onClickMaterialCardView.onClick(favoriteMovie)
        }
    }
    @SuppressLint("NotifyDataSetChange")
    fun setMovies ( favorite: MutableList<MovieFavDetail>){
        this.favoritesMovies = favorite
        notifyDataSetChanged()
    }


    fun setOnClickMaterialCardView(onClickMaterialCardView: OnClickMaterialCardView) {

        this.onClickMaterialCardView = onClickMaterialCardView
    }

    interface OnClickMaterialCardView {
        fun onClick(favorite: MovieFavDetail)
    }


    class MyFavoriteViewHolder(val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root)


}




