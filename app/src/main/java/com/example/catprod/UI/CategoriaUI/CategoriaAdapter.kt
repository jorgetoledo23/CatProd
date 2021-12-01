package com.example.catprod.UI.CategoriaUI

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.catprod.Data.Categoria
import com.example.catprod.Data.CategoriaAndProductos
import com.example.catprod.Data.TiendaDb
import com.example.catprod.R
import com.example.catprod.databinding.CategoriaItemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriaAdapter(var listaCategorias:List<CategoriaAndProductos>):RecyclerView.Adapter<CategoriaAdapter.Holder>() {

    class Holder(var view: View):RecyclerView.ViewHolder(view){
        val binding:CategoriaItemBinding = CategoriaItemBinding.bind(view)
        var database = TiendaDb.getDatabase(view.context)

        fun bind(categoria:CategoriaAndProductos){
            binding.tvCategoriaNombre.text = categoria.Categoria.CategoriaNombre
            binding.tvCategoriaDescripcion.text = categoria.Categoria.CategoriaDescripcion

            Glide.with(view.context).load(categoria.Categoria.CategoriaImagen).into(binding.ivCategoriaImagen)

            binding.cvCategoria.setOnClickListener{verProductos(categoria.Categoria)}
            binding.btnDelete.setOnClickListener{eliminarCategoria(categoria.Categoria)}
        }

        private fun eliminarCategoria(categoria: Categoria) {

            val context = view.context
            var intent = Intent(context, DeleteCategoriaActivity::class.java)
            intent.putExtra("Categoria", categoria)
            context.startActivity(intent)



        }

        private fun verProductos(categoria: Categoria) {
            TODO("Abrir actividad que me muestre los productos de la categoria seleccionada")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return Holder(layoutInflater.inflate(R.layout.categoria_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(listaCategorias[position])
    }

    override fun getItemCount(): Int {
        return listaCategorias.size
    }


}