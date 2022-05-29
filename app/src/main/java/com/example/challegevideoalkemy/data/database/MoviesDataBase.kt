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

    companion object {
        private const val DATABASE_NAME = "videoteca_db"
        private var INSTANCE: MoviesDataBase? = null

        fun getInstanceDb(context: Context): MoviesDataBase {

            INSTANCE ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    MoviesDataBase::class.java,
                    DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE!!
        }
    }





}
