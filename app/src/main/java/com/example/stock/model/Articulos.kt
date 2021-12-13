package com.example.stock.model

import androidx.room.*

@Entity(tableName = "articulos")
class Articulos(
    @PrimaryKey
    var identificador:String,
    var descripcion:String,
    var cantidad:String,
) {}