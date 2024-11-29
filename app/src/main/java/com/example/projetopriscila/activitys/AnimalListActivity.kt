package com.example.projetopriscila.activitys


import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.projetopriscila.R
import com.example.projetopriscila.adapter.AnimalAdapter
import com.example.projetopriscila.repository.AnimalRepository

class AnimalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)

        val animalListView = findViewById<ListView>(R.id.animalListView)
        val adapter = AnimalAdapter(this, AnimalRepository.getAnimals())
        animalListView.adapter = adapter

        // Clique em item para abrir detalhes
        animalListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, AnimalDetailsActivity::class.java)
            intent.putExtra("ANIMAL_INDEX", position)
            startActivity(intent)
        }
    }
}
