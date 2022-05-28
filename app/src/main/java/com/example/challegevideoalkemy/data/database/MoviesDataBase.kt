package com.example.challegevideoalkemy.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.challegevideoalkemy.domain.entities.Favorite
import kotlinx.coroutines.InternalCoroutinesApi



@Database(
    version = 3,
    entities = [Favorite::class]
)

abstract class MoviesDataBase : RoomDatabase() {
    abstract fun favoriteDao(): FavDao

     companion object{
         private var INSTANCE : MoviesDataBase? = null
         fun getDatabase(context : Context) : MoviesDataBase{

             INSTANCE = INSTANCE ?: Room.databaseBuilder(context.applicationContext , MoviesDataBase::class.java , "cards").build()

             return INSTANCE!!
         }

         fun destroyInstance(){
             INSTANCE = null
         }
     }





}
