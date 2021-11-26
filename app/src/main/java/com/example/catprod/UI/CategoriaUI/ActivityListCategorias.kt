package com.example.catprod.UI.CategoriaUI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catprod.Data.CategoriaProvider
import com.example.catprod.Data.TiendaDb
import com.example.catprod.databinding.ActivityListCategoriasBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityListCategorias : AppCompatActivity() {

    private lateinit var binding : ActivityListCategoriasBinding
    private lateinit var database : TiendaDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListCategoriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = TiendaDb.getDatabase(this)

        binding.btnAddCategoria.setOnClickListener{ openAddCategoria() }

        initRecycler()


    }

    private fun openAddCategoria() {
        val intent = Intent(this, AddCategoriaActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        //Toast.makeText(this, "Categoria Almacenada con Exito!", Toast.LENGTH_LONG).show()
        super.onResume()
        initRecycler()
    }

    private fun initRecycler() {
        binding.recyclerCategorias.layoutManager = LinearLayoutManager(this)
        val adapter = CategoriaAdapter(CategoriaProvider.getCategorias())
        binding.recyclerCategorias.adapter = adapter
    }
}