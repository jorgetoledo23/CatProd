package com.example.catprod.UI.ProductoUI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.catprod.databinding.ActivityAddProductoBinding
import com.example.catprod.R
import android.content.Context
import android.view.View
import android.view.ViewGroup

import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.catprod.Data.Categoria
import com.example.catprod.Data.CategoriaAndProductos
import com.example.catprod.Data.CategoriaProvider
import com.google.android.material.textfield.TextInputLayout


class AddProductoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddProductoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)



        var ListaCategorias = CategoriaProvider.getCategorias()


        class CategoriaAdapter(context: Context) : BaseAdapter() {
            override fun getCount(): Int {
                return ListaCategorias.size
            }

            override fun getItem(position: Int): Any {
                return ListaCategorias[position]
            }

            override fun getItemId(position: Int): Long {
                return position.toLong()
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                var Holder:CategoriaHolder = CategoriaHolder()
                var CategoriaView = convertView
                CategoriaView = layoutInflater.inflate(R.layout.spinner, parent, false)


                Holder.tvNombre = CategoriaView.findViewById(R.id.tvCategoriaNombre)

                CategoriaView.tag = Holder

                var categoria = ListaCategorias.get(position)
                Holder.tvCat.text = categoria.Categoria.CategoriaId.toString()
                Holder.tvNombre.text = categoria.Categoria.CategoriaNombre

                return CategoriaView

            }



        }

        var categoriaAdapter:CategoriaAdapter = CategoriaAdapter(this)





        var spinner = binding.CategoriaSpinner
        spinner.setAdapter(categoriaAdapter);

    }
}

class CategoriaHolder {
    lateinit var tvNombre: TextInputLayout
}
