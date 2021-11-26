package com.example.catprod.UI.ProductoUI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.catprod.UI.CategoriaUI.AddCategoriaActivity
import com.example.catprod.databinding.ActivityProductosListBinding

class ProductosListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProductosListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductosListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddProducto.setOnClickListener{

            openAddProducto()

        }
    }

    private fun openAddProducto() {
        val intent = Intent(this, AddProductoActivity::class.java)
        startActivity(intent)
    }
}