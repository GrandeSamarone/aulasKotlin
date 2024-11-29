package com.example.projetopriscila.activitys


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projetopriscila.R
import com.example.projetopriscila.model.Golfinho
import com.example.projetopriscila.repository.AnimalRepository

class AnimalDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_detail)

        val animalIndex = intent.getIntExtra("ANIMAL_INDEX", -1)
        val animal = AnimalRepository.getAnimal(animalIndex)

        if (animal != null) {
            val detailsTextView = findViewById<TextView>(R.id.animalInfoTextView)
            detailsTextView.text = animal.info() + "\nSom: ${animal.falar()}"

            if (animal is Golfinho) {
               // detailsTextView.append("\nAção: ${animal.nadar()}")
            }
        }
    }
}
