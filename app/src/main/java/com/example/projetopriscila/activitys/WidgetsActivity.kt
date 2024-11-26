package com.example.projetopriscila.activitys

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.projetopriscila.R

class WidgetsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widgets)

        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        val imageView = findViewById<ImageView>(R.id.imageView)

        // Exibir texto ao clicar no botão
        button.setOnClickListener {
            val input = editText.text.toString()
            if (input.isNotEmpty()) {
                textView.text = "Você digitou: $input"
                Toast.makeText(this, "Texto exibido com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                editText.error = "Digite algo antes de continuar!"
            }
        }

        // Alterar a imagem ao pressionar o botão
        button.setOnLongClickListener {
            imageView.setImageResource(R.drawable.ic_launcher_foreground)
            Toast.makeText(this, "Imagem alterada!", Toast.LENGTH_SHORT).show()
            true
        }
    }
}