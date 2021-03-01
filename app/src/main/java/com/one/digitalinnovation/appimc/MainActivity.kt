package com.one.digitalinnovation.appimc

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        calculaBTN?.setOnClickListener {
            calculaImc(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
    }

    private fun calculaImc(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        val tempo = Toast.LENGTH_SHORT
        val retorno:String

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            resultadoTXT.text = "IMC = $imc"
            classificaIMC(imc)
        }else{
            if (peso == null) {
                Toast.makeText(this, "Peso não informado", tempo).show()
            }else{
                if (altura == null) {
                    Toast.makeText(this, "Altura não informada", tempo).show()
                }
            }
        }
    }

    private fun classificaIMC(imc: Float) {
        var retorno: String = ""
        when (imc) {
            in 0.0f..18.5f -> retorno = "Abaixo do peso"
            in 18.6f..24.9f -> retorno = "Peso normal"
            in 25.0f..29.9f -> retorno = "Sobrepeso"
            in 30.0f..34.9f -> retorno = "Obesidade"
            in 35.0f..39.9f -> retorno = "Obesidade Severa"
            in 40.0f..99.9f -> retorno = "Obesidade Mórbida"
            else -> retorno = "Sem classificação"
        }
        classificacaoTXT.text = "Classificação: $retorno"
    }
}