package com.example.challegevideoalkemy.domain.model

import com.google.gson.annotations.SerializedName

data class Movie (

    @SerializedName ("id")
    var id : Int,

    @SerializedName ("original_title")
    var  title: String,

    @SerializedName ("poster_path")
    var image : String,

    @SerializedName ("original_language")
    var lenguage: String,

    @SerializedName("overview")
    var descripcion: String,

    @SerializedName ("popularity")
    var popularity: String,

    @SerializedName("release_date")
    var premiere: String,

    @SerializedName("genre_ids")
    var genresIds: List<Int>,

    @SerializedName("runtime")
    var duration: Int,
 )

 data class  MovieResponse(

    @SerializedName("results")
    val results: MutableList<Movie>
)