package com.example.stock

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.stock.model.Articulos
import kotlinx.coroutines.launch

class ArticulosViewModel: ViewModel() {

    private var listaArticulos: LiveData<MutableList<Articulos>> = liveData {
        listaArticulos =Persistencia.database.articulosDao().getAll()
        emitSource(listaArticulos)
    }

    fun getAll(): LiveData<MutableList<Articulos>> {
        return listaArticulos
    }

    fun delete() {
        viewModelScope.launch {
            Persistencia.database.articulosDao().delete()
        }
    }

    fun insertArticulo(articulos: Articulos) {
        viewModelScope.launch {
            Persistencia.database.articulosDao().insertArticulo(articulos)
        }
    }
}