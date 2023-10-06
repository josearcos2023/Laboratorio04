package com.jose.arcos.laboratorio04

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jose.arcos.laboratorio04.databinding.ActivityEjercicioCalificadoContactoBinding

class EjercicioCalificadoContacto : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicioCalificadoContactoBinding

    val parameter_extra_nombre = "nombre"
    val parameter_extra_correo = "correo"
    val parameter_extra_celular = "celular"
    val parameter_extra_oficina = "oficina"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEjercicioCalificadoContactoBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        val extras = this.intent.extras

        if (extras != null){
            if (extras.get(parameter_extra_nombre) != null){
                binding.contactName.text = extras.getString(parameter_extra_nombre)
            }
            if (extras.get(parameter_extra_correo) != null){
                binding.contactEmail.text = extras.getString(parameter_extra_correo)
            }
            if (extras.get(parameter_extra_celular) != null){
                binding.contactCellphone.text = extras.getString(parameter_extra_celular)
            }
            if (extras.get(parameter_extra_oficina) != null){
                binding.contactOffice.text = extras.getString(parameter_extra_oficina)
            }
        }

        binding.btnSms.setOnClickListener {
            val cellphone = binding.contactCellphone.text.toString()

            val smsUri = "smsto:$cellphone"

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse(smsUri)

            startActivity(intent)
        }

        binding.btnLlamar.setOnClickListener {
            val cellphone = binding.contactCellphone.text.toString()

            val phoneNumberUri = "tel:$cellphone"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(phoneNumberUri)
            startActivity(intent)
        }

        binding.btnCorreo.setOnClickListener {
            val email = binding.contactEmail.text.toString()

            val emailUri = Uri.parse("mailto:$email")

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = emailUri

            startActivity(intent)
        }

        binding.btnWsp.setOnClickListener {
            val cellphone = binding.contactCellphone.text.toString()
            val url = "https://api.whatsapp.com/send?phone=$cellphone"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)

            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Aplicación no instalada en este dispositivo", Toast.LENGTH_SHORT).show()
            }
        }
    }
}