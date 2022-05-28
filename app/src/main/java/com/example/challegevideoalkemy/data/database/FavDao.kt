package com.example.challegevideoalkemy.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.challegevideoalkemy.domain.entities.Favorite

@Dao
interface FavDao {

    @Insert
    fun insertFavorite (favorite : Favorite)

    @Delete
    fun deleteFavorite (favorite : Favorite)


    @Query ("select * from favorite_table where favoriteID= :id")
    fun getFavoriteById (id : Int?) : Favorite

}