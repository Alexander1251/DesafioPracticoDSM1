package com.example.desafiopractico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.desafiopractico.databinding.ActivityCalculadoraBinding
import kotlin.math.pow
import kotlin.math.sqrt

class CalculadoraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculadoraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val operaciones = listOf("Suma", "Resta", "Multiplicación", "División", "Exponente", "Raíz Cuadrada")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operaciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerOperaciones.adapter = adapter

        binding.btnCalcularOperacion.setOnClickListener {
            val operacion = binding.spinnerOperaciones.selectedItem.toString()
            val op1 = binding.etOperando1.text.toString().toDoubleOrNull()
            val op2 = binding.etOperando2.text.toString().toDoubleOrNull()

            if (op1 == null) {
                Toast.makeText(this, "Ingrese el Operando 1", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var resultado: Double? = null
            when (operacion) {
                "Suma" -> {
                    if (op2 == null) {
                        Toast.makeText(this, "Ingrese el Operando 2", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    resultado = op1 + op2
                }
                "Resta" -> {
                    if (op2 == null) {
                        Toast.makeText(this, "Ingrese el Operando 2", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    resultado = op1 - op2
                }
                "Multiplicación" -> {
                    if (op2 == null) {
                        Toast.makeText(this, "Ingrese el Operando 2", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    resultado = op1 * op2
                }
                "División" -> {
                    if (op2 == null || op2 == 0.0) {
                        Toast.makeText(this, "Ingrese un Operando 2 válido", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    resultado = op1 / op2
                }
                "Exponente" -> {
                    if (op2 == null) {
                        Toast.makeText(this, "Ingrese el Operando 2", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    resultado = op1.pow(op2)
                }
                "Raíz Cuadrada" -> {
                    if (op1 < 0) {
                        Toast.makeText(this, "No se puede calcular la raíz de un número negativo", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    resultado = sqrt(op1)
                }
            }
            binding.tvResultadoCalculadora.text = "Resultado: ${resultado?.let { "%.2f".format(it) } ?: "Error"}"
        }
    }
}
