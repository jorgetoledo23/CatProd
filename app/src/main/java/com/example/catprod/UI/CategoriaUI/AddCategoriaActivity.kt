package com.example.catprod.UI.CategoriaUI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.catprod.Data.Categoria
import com.example.catprod.Data.CategoriaProvider
import com.example.catprod.Data.TiendaDb
import com.example.catprod.databinding.ActivityAddCategoriaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddCategoriaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddCategoriaBinding
    private lateinit var database : TiendaDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = TiendaDb.getDatabase(this)

        binding.btnAddCategoria.setOnClickListener{ addCategoria() }

    }

    private fun addCategoria() {

        var x = binding.txtCategoriaDescripcion

        var NombreCategoria = binding.txtCategoriaNombre.editText?.text.toString()
        var DescripcionCategoria = binding.txtCategoriaDescripcion.editText?.text.toString()
        var ImagenCategoria = binding.txtCategoriaImagen.editText?.text.toString()

        var CategoriaNueva = Categoria(
            CategoriaNombre=NombreCategoria,
            CategoriaDescripcion = DescripcionCategoria,
            CategoriaImagen = ImagenCategoria)

        CoroutineScope(Dispatchers.IO).launch {
            database.TiendaDAO().save(CategoriaNueva)
            CategoriaProvider.setCategorias(database.TiendaDAO().getAll())
            this@AddCategoriaActivity.finish()
        }




    }
}