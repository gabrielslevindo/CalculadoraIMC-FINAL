package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //Ligação do XML ao Kotlin


        // recuperar UI Componrt no arquivo Kotlin
        //colocar ação no botão
        //Id do componente



        val calcular:Button = findViewById(R.id.calcular) //recuperação do botão via Id
        val edtpeso : EditText = findViewById(R.id.edttext_peso) //entrada de dados por texto
        val edtalt : EditText = findViewById(R.id.edttext_alt) //entrada de dados por texto


        calcular.setOnClickListener {


           val altura: Float = edtalt.text.toString().toFloat()
            val altFinal :Float = altura * altura
            val peso: Float = edtpeso.text.toString().toFloat()
            val result: Float = peso / altFinal



            val intent = Intent(this, ResultActivity::class.java)  //aqui passamos de uma tela pra outra na Intent.

                .apply {

                   putExtra("EXTRA_RESULT", result)

                }
            startActivity(intent)

        }




    }
}