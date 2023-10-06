package com.jose.arcos.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jose.arcos.laboratorio04.databinding.ActivityEjercicioCalificadoBinding

class EjercicioCalificado : AppCompatActivity() {

    private val parameter_extra_nombre = "nombre"
    private val parameter_extra_correo = "correo"
    private val parameter_extra_celular = "celular"
    private val parameter_extra_oficina = "oficina"

    private lateinit var binding: ActivityEjercicioCalificadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEjercicioCalificadoBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)

        binding.btnSaveExplicit.setOnClickListener{

            val fullname = binding.fullnameInput.text.toString()
            val email = binding.emailInput.text.toString()
            val cellphone = binding.cellphoneInput.text.toString()
            val office = binding.officeInput.text.toString()
            val intent = Intent(this,EjercicioCalificadoContacto::class.java)
            intent.putExtra(parameter_extra_nombre,fullname)
            intent.putExtra(parameter_extra_correo,email)
            intent.putExtra(parameter_extra_celular,cellphone)
            intent.putExtra(parameter_extra_oficina,office)

            if (fullname=="" || email=="" || cellphone=="" || office==""){
                Toast.makeText(this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(intent)
            }
        }
    }
}