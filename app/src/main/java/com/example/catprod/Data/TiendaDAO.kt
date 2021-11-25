package com.example.catprod.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface TiendaDAO {

    @Insert
    suspend fun save(categoria: Categoria)

    @Insert
    suspend fun save(vararg producto: Producto)

    @Transaction
    @Query("SELECT * FROM tblCategorias")
    suspend fun getAll(): List<CategoriaAndProductos>

    @Transaction
    @Query("SELECT * FROM tblCategorias WHERE CategoriaId = :CategoriaId")
    suspend fun getByCategoriaId(CategoriaId: Int): CategoriaAndProductos


}