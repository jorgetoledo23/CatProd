package com.example.catprod.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.catprod.Data.CategoriaProvider
import com.example.catprod.Data.TiendaDb
import com.example.catprod.UI.CategoriaUI.ActivityListCategorias
import com.example.catprod.UI.ProductoUI.AddProductoActivity
import com.example.catprod.UI.ProductoUI.ProductosListActivity
import com.example.catprod.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var database : TiendaDb
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvCat.setOnClickListener{ openListCategorias() }
        binding.cvProd.setOnClickListener{ openListProductos() }

        database = TiendaDb.getDatabase(this)

        CoroutineScope(Dispatchers.IO).launch {
            CategoriaProvider.setCategorias(database.TiendaDAO().getAll())
        }


    }

    private fun openListCategorias() {
        val intent = Intent(this, ActivityListCategorias::class.java)
        startActivity(intent)
    }

    private fun openListProductos() {
        val intent = Intent(this, ProductosListActivity::class.java)
        startActivity(intent)
    }

}