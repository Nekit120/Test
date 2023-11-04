package com.Nekit120.codeholder.data.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ItemFoodDTO::class], exportSchema = false, version = 1)
abstract class MainDatabase : RoomDatabase() {
    abstract fun getMenuDao(): MenuDao

    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "database.db"
                ).fallbackToDestructiveMigration()  .build()
                instance
            }
        }
    }
}