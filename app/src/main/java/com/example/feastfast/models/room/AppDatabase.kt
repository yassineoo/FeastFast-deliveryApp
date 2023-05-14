package com.example.feastfast.models.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.feastfast.models.CartItem
import com.example.feastfast.models.room.DAO.CartItemDao


@Database(entities = [CartItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMenuItemDao() : CartItemDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java,
                        "cart_db").allowMainThreadQueries().build() }

            return INSTANCE
        }
    }
}