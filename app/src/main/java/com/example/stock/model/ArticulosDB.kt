package com.example.stock.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Articulos::class),version = 1, exportSchema = false)
abstract class ArticulosDB: RoomDatabase() {
    abstract fun articulosDao():ArticulosDao

}