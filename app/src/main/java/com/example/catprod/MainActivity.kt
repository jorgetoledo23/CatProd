package com.example.catprod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.catprod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(3000)
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}