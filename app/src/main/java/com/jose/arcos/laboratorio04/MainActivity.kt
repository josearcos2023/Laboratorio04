package com.jose.arcos.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jose.arcos.laboratorio04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val ACTIVITY_A_REQUEST = 240

    val ACTIVITY_B_REQUEST = 241

    val TAG = MainActivity::class.java.toString()

    val PARAMETER_EXTRA_CODE = "code"
    val PARAMETER_EXTRA_FULL_NAME = "fullname"
    val PARAMETER_EXTRA_AMOUNT = "amount"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)

        binding.btnExplicit.setOnClickListener {

            val fullName = binding.fullnameInput.text.toString()
            val code = binding.codeInput.text.toString()
            val amount = binding.amountInput.text.toString()

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(PARAMETER_EXTRA_CODE, code)
            intent.putExtra(PARAMETER_EXTRA_FULL_NAME, fullName)
            intent.putExtra(PARAMETER_EXTRA_AMOUNT, amount)

            startActivity(intent)
        }

        binding.btnImplicit.setOnClickListener {

            val fullName = binding.fullnameInput.text.toString()
            val code = binding.codeInput.text.toString()
            val amount = binding.amountInput.text.toString()

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Code: $code, Fullname: $fullName, Amount: $amount")
            intent.type = "text/plain"
            startActivity(intent)
        }
    }
}