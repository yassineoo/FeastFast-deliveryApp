package com.example.feastfast.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.feastfast.panier
import com.example.feastfast.panierDoa

@Database(entities = [panier::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getPanierDoa(): panierDoa
    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context,AppDatabase::class.java,
                        "feastFast").allowMainThreadQueries().build() }

            return INSTANCE
        }
    }
}