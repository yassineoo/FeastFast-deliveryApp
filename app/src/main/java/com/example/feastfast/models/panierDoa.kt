package com.example.feastfast

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface panierDoa {
    @Query("select * from panier ")
    fun getPanier():List<panier>
    @Insert
    fun addToPanier(vararg panierObj: panier)

    @Delete
    fun deleteFromPanier(panierObj: panier)
}