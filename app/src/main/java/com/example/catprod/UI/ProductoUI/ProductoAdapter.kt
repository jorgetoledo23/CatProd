package com.example.catprod.UI.ProductoUI

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.catprod.Data.Categoria
import com.example.catprod.Data.CategoriaAndProductos
import com.example.catprod.Data.Producto
import com.example.catprod.Data.TiendaDb
import com.example.catprod.R
import com.example.catprod.UI.CategoriaUI.CategoriaAdapter
import com.example.catprod.UI.CategoriaUI.DeleteCategoriaActivity
import com.example.catprod.databinding.CategoriaItemBinding
import com.example.catprod.databinding.ProductoItemBinding

class ProductoAdapter(var listaProductos:List<Producto>):
    RecyclerView.Adapter<ProductoAdapter.Holder>() {

    class Holder(var view: View): RecyclerView.ViewHolder(view){
        val binding: ProductoItemBinding = ProductoItemBinding.bind(view)
        var database = TiendaDb.getDatabase(view.context)

        fun bind(producto: Producto){
            binding.tvProductoNombre.text = producto.ProductoName
            binding.tvProductoDescripcion.text = producto.ProductoDescripcion
            binding.tvProductoPrecio.text = producto.ProductoPrecio.toString()
            binding.tvProductoStock.text = producto.ProductoStock.toString()

            Glide.with(view.context).load(producto.ProductoImagen).into(binding.ivProductoImagen)

            //binding.cvCategoria.setOnClickListener{verProductos(categoria.Categoria)}
            binding.btnDelete.setOnClickListener{eliminarProducto(producto)}
        }

        private fun eliminarProducto(producto: Producto) {

            val context = view.context
            var intent = Intent(context, DeleteCategoriaActivity::class.java)
            intent.putExtra("Producto", producto)
            context.startActivity(intent)

        }

        private fun verProductos(categoria: Categoria) {
            TODO("Abrir actividad que me muestre los productos de la categoria seleccionada")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return Holder(layoutInflater.inflate(R.layout.producto_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(listaProductos[position])
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }


}