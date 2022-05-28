package com.example.challegevideoalkemy.domain.model

import com.google.gson.annotations.SerializedName

data class MovieFavDetail(

    var id: Int,

    @SerializedName("poster_path")
    var image: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("overview")
    var descripcion: String
)