package com.example.projetopriscila.activitys


import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.projetopriscila.R
import com.example.projetopriscila.model.Cachorro
import com.example.projetopriscila.model.Gato
import com.example.projetopriscila.model.Golfinho
import com.example.projetopriscila.repository.AnimalRepository

class AddAnimalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_animal)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        val typeSpinner = findViewById<Spinner>(R.id.typeSpinner)
        val addButton = findViewById<Button>(R.id.addButton)

        // Configurando Spinner
        val types = arrayOf("Cachorro", "Gato", "Golfinho")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, types)
        typeSpinner.adapter = adapter

        addButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val age = ageEditText.text.toString().toIntOrNull()
            val type = typeSpinner.selectedItem.toString()

            if (name.isNotEmpty() && age != null) {
                val animal = when (type) {
                    "Cachorro" -> Cachorro(name, age)
                    "Gato" -> Gato(name, age)
                    "Golfinho" -> Golfinho(name, age)
                    else -> null
                }
                if (animal != null) {
                    AnimalRepository.addAnimal(animal)
                    Toast.makeText(this, "$type adicionado com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos corretamente.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
