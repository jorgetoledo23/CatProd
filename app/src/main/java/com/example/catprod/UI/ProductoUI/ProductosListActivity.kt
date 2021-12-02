package com.example.catprod.UI.ProductoUI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catprod.Data.CategoriaProvider
import com.example.catprod.Data.TiendaDb
import com.example.catprod.UI.CategoriaUI.AddCategoriaActivity
import com.example.catprod.UI.CategoriaUI.CategoriaAdapter
import com.example.catprod.databinding.ActivityProductosListBinding

class ProductosListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProductosListBinding
    private lateinit var database : TiendaDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductosListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = TiendaDb.getDatabase(this)

        binding.btnAddProducto.setOnClickListener{ openAddProducto() }
    }

    private fun openAddProducto() {
        val intent = Intent(this, AddProductoActivity::class.java)
        startActivity(intent)
    }

    private fun initRecycler() {
        binding.recyclerProductos.layoutManager = LinearLayoutManager(this)
        val adapter = ProductoAdapter(database.TiendaDAO().getAllProductos())
        binding.recyclerProductos.adapter = adapter
    }



}