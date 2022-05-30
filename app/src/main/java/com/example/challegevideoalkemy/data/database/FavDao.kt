package com.example.challegevideoalkemy.data.database

import androidx.room.*
import com.example.challegevideoalkemy.domain.entities.Favorite

@Dao
interface FavDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite (favorite : Favorite)

    @Delete
    fun deleteFavorite (favorite : Favorite)


    @Query ("select * from favorite_table where favoriteID= :id")
    fun getFavoriteById (id : Int?) : Favorite

}