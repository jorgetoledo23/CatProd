package com.example.catprod.Data

import androidx.room.Embedded
import androidx.room.Relation
import java.io.Serializable

data class CategoriaAndProductos (
    @Embedded
    val Categoria : Categoria,
    @Relation(
        parentColumn = "CategoriaId",
        entityColumn = "ProductoCategoria"
    )
    val Productos : List<Producto>
        ) : Serializable
