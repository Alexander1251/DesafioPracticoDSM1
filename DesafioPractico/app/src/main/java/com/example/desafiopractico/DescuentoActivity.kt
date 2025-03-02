package com.example.desafiopractico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desafiopractico.databinding.ActivityDescuentoBinding

class DescuentoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDescuentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescuentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcularDescuentos.setOnClickListener {
            val nombre = binding.etNombreEmpleado.text.toString()
            val salarioBase = binding.etSalarioBase.text.toString().toDoubleOrNull()

            if (nombre.isEmpty() || salarioBase == null) {
                Toast.makeText(this, "Complete los campos correctamente", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val renta = if (salarioBase > 1000) salarioBase * 0.10 else 0.0
            val afp = salarioBase * 0.0725
            val isss = salarioBase * 0.03
            val salarioNeto = salarioBase - renta - afp - isss

            val detalle = """
                Empleado: $nombre
                Salario Base: ${"%.2f".format(salarioBase)}
                Renta: ${"%.2f".format(renta)}
                AFP (7.25%): ${"%.2f".format(afp)}
                ISSS (3%): ${"%.2f".format(isss)}
                Salario Neto: ${"%.2f".format(salarioNeto)}
            """.trimIndent()

            binding.tvResultadoDescuentos.text = detalle
        }
    }
}

