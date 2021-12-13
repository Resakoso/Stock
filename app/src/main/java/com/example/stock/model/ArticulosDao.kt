package com.example.stock.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface ArticulosDao {

    @Query("SELECT * From Articulos")
    fun getAll(): LiveData<MutableList<Articulos>>

    @Insert
    suspend fun insertArticulo(articulo:Articulos)

    @Query("DELETE FROM Articulos")
    suspend fun delete()

}