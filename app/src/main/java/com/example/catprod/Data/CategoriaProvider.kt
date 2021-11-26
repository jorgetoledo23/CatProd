package com.example.catprod.Data

class CategoriaProvider {

    companion object{

        private var Categorias = listOf<CategoriaAndProductos>()

        fun setCategorias(categoria:List<CategoriaAndProductos>){
            Categorias = categoria
        }

        fun getCategorias():List<CategoriaAndProductos>{
            return this.Categorias
        }

    }


}