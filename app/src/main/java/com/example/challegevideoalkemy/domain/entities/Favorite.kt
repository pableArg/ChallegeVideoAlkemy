package com.example.challegevideoalkemy.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "favorite_table")

data class Favorite(

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "favoriteID")
    val id: Int = 0,

    @ColumnInfo (name ="favoriteTitle")
    val title: String ,

    @ColumnInfo (name ="favoriteImage")
    val image: String



)