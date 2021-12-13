package com.example.stock

import android.app.Application
import androidx.room.Room
import com.example.stock.model.ArticulosDB

class Persistencia: Application() {
    companion object{
        lateinit var database: ArticulosDB
    }
    override fun onCreate() {
        super.onCreate()
        database = Room
            .databaseBuilder(this, ArticulosDB::class.java,getString(R.string.nombre_basedatos))
            .build()
    }
}