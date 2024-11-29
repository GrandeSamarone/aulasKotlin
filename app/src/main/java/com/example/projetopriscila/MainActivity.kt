package com.example.projetopriscila

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.projetopriscila.activitys.AddAnimalActivity
import com.example.projetopriscila.activitys.AnimalListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addAnimalButton = findViewById<Button>(R.id.addAnimalButton)
        val viewAnimalsButton = findViewById<Button>(R.id.viewAnimalsButton)

        // Botão para abrir tela de cadastro de animais
        addAnimalButton.setOnClickListener {
            startActivity(Intent(this, AddAnimalActivity::class.java))

        }

        // Botão para abrir lista de animais
        viewAnimalsButton.setOnClickListener {
            startActivity(Intent(this, AnimalListActivity::class.java))
        }
    }
}

