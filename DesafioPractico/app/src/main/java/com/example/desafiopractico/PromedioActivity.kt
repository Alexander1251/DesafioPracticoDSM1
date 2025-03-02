package com.example.desafiopractico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desafiopractico.databinding.ActivityPromedioBinding

class PromedioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPromedioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPromedioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcularPromedio.setOnClickListener {
            val nombre = binding.etNombre.text.toString()
            val nota1 = binding.etNota1.text.toString().toDoubleOrNull()
            val nota2 = binding.etNota2.text.toString().toDoubleOrNull()
            val nota3 = binding.etNota3.text.toString().toDoubleOrNull()
            val nota4 = binding.etNota4.text.toString().toDoubleOrNull()
            val nota5 = binding.etNota5.text.toString().toDoubleOrNull()

            if (nombre.isEmpty() || nota1 == null || nota2 == null ||
                nota3 == null || nota4 == null || nota5 == null) {
                Toast.makeText(this, "Complete todos los campos con valores válidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val notas = listOf(nota1, nota2, nota3, nota4, nota5)
            if (notas.any { it < 0 || it > 10 }) {
                Toast.makeText(this, "Las notas deben estar entre 0 y 10", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val promedio = (nota1 * 0.15 + nota2 * 0.15 + nota3 * 0.20 + nota4 * 0.25 + nota5 * 0.25)
            val resultado = if (promedio >= 6.0) "Aprobó" else "Reprobó"

            binding.tvResultadoPromedio.text = "Estudiante: $nombre\nPromedio: %.2f\nResultado: %s"
                .format(promedio, resultado)
        }
    }
}
