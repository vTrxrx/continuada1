package com.example.calculadora_porcentagem

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcular(componente: View) {
        val porcentagem = et_porcentagem.text.toString()
        val quantia = et_quantia.text.toString()
        var isValid = true

        if(et_porcentagem.text.isNullOrEmpty()) {
            isValid = false
            et_porcentagem.setError("Deve ser preenchido")
        }

        if(et_quantia.text.isNullOrEmpty()) {
            isValid = false
            et_quantia.setError("Deve ser preenchido")
        }

        if(isValid) {
            val resultado = (porcentagem.toDouble() / 100) * quantia.toDouble()

            if(resultado < 0) {
                tv_resultado.setTextColor(Color.RED)
            } else {
                tv_resultado.setTextColor(Color.GREEN)
            }

            tv_resultado.text = resultado.toString()
            tv_resultado.visibility = View.VISIBLE
        }
    }
}