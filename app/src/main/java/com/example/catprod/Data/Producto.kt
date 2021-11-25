package com.example.catprod.Data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tblProductos",
    foreignKeys = [ForeignKey(
        entity = Categoria::class,
        parentColumns = arrayOf("CategoriaId"),
        childColumns = arrayOf("ProductoCategoria"),
        onDelete = ForeignKey.CASCADE
    )]
    )
data class Producto (
    @PrimaryKey(autoGenerate = true)
    val ProductoId : Int =0,
    val ProductoName: String,
    val ProductoPrecio : Int,
    val ProductoDescripcion : String,
    val ProductoStock : Int,
    val ProductoImagen : String,
    val ProductoCategoria : Int


        ) : Serializable