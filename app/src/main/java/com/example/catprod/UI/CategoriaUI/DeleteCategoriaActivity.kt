package com.example.catprod.UI.CategoriaUI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.catprod.Data.Categoria
import com.example.catprod.Data.TiendaDb
import com.example.catprod.databinding.ActivityDeleteCategoriaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeleteCategoriaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDeleteCategoriaBinding
    private lateinit var database : TiendaDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = TiendaDb.getDatabase(this)

        val bundle = intent.extras
        val categoria: Categoria = bundle?.getSerializable("Categoria") as Categoria


        binding.tvCategoriaNombre.text = categoria.CategoriaNombre

        binding.btnCancelar.setOnClickListener { cerrar() }
        binding.btnEliminar.setOnClickListener { eliminarCategoria(categoria) }





    }

    private fun cerrar() {
        this@DeleteCategoriaActivity.finish()
    }

    private fun eliminarCategoria(categoria:Categoria) {
        CoroutineScope(Dispatchers.IO).launch {
            database.TiendaDAO().delete(categoria)
            this@DeleteCategoriaActivity.finish()
        }
    }
}