package com.example.challegevideoalkemy.domain.model

import com.google.gson.annotations.SerializedName

data class Genre (
    @SerializedName ("id")
    var id : String,

    @SerializedName ("name")
    var name : String)

data class GenreList (
@SerializedName("results")
var results: List<Genre>)