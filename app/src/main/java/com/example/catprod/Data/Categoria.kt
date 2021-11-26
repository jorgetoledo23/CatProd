package com.example.catprod.Data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tblCategorias")
data class Categoria (
    @PrimaryKey(autoGenerate = true)
    val CategoriaId : Int = 0,
    val CategoriaNombre : String,
    val CategoriaDescripcion : String,
    val CategoriaImagen : String
    ):Serializable