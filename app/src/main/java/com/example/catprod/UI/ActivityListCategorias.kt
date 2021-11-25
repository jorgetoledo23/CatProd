package com.example.catprod.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.catprod.databinding.ActivityListCategoriasBinding

class ActivityListCategorias : AppCompatActivity() {
    private lateinit var binding : ActivityListCategoriasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListCategoriasBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}