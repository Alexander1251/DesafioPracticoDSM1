package com.example.desafiopractico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiopractico.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPromedio.setOnClickListener {
            startActivity(Intent(this, PromedioActivity::class.java))
        }
        binding.btnDescuento.setOnClickListener {
            startActivity(Intent(this, DescuentoActivity::class.java))
        }
        binding.btnCalculadora.setOnClickListener {
            startActivity(Intent(this, CalculadoraActivity::class.java))
        }
    }
}
