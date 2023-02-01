package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        val tvresult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
      val result =  intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvresult.text= result.toString()


        /* TABELA IMC

       < 18,5 = ABAIXO DO PESO;
       >= 18,5 && <=24,9 = NORMAL;
      >= 25,0 && <= 29,9 = SOBREPESO 1;
      >= 30,0 && <= 39,9 = OBESIDADE 2;
      >= 40,0 = OBESIDADE GRAVE 2;


      MENOR QUE 18,5	MAGREZA	0
ENTRE 18,5 E 24,9	NORMAL	0
ENTRE 25,0 E 29,9	SOBREPESO	I
ENTRE 30,0 E 39,9	OBESIDADE	II
MAIOR QUE 40,0	OBESIDADE GRAVE	III

         */
        var classificacao = ""

        if (result >= 18.5f) {
            when (result) {
                in 18.5f..24.9f -> {

                    classificacao = "PESO NORMAL."

                }
                in 25.0f..29.9f -> {

                    classificacao = "SOBREPESO 1"


                }
                in 30.0f..39.9f -> {

                    classificacao = "OBESIDADE"

                }
                else -> {

                    classificacao = "OBESIDADE GRAVE"

                }
            }
        } else {

            classificacao = "ABAIXO DO PESO."

        }

        tvClassificacao.text= getString(R.string.message_classificacao, classificacao)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }


}