package com.example.catprod.Data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TiendaDAO {

    @Insert
    fun save(categoria: Categoria)

    @Delete
    fun delete(categoria: Categoria)

    @Insert
    fun save(vararg producto: Producto)

    @Transaction
    @Query("SELECT * FROM tblProductos")
    fun getAllProductos(): List<Producto>

    @Transaction
    @Query("SELECT * FROM tblCategorias")
    fun getAll(): List<CategoriaAndProductos>

    @Transaction
    @Query("SELECT * FROM tblCategorias WHERE CategoriaId = :CategoriaId")
    fun getByCategoriaId(CategoriaId: Int): CategoriaAndProductos


}