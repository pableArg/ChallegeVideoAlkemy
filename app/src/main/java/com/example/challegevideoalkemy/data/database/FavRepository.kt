package com.example.challegevideoalkemy.data.database

import com.example.challegevideoalkemy.domain.entities.Favorite


class FavRepository(private val favoriteDao: FavDao) {

    fun insertFavorite(favorite: Favorite) {
        favoriteDao.insertFavorite(favorite)
    }

    fun deleteFavorite(favorite: Favorite) {
        favoriteDao.deleteFavorite(favorite)

    }


    fun getFavoriteById  (id : Int) : Favorite{
        return favoriteDao.getFavoriteById(id)
    }



}