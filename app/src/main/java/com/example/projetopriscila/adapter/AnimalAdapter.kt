package com.example.projetopriscila.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.projetopriscila.R
import com.example.projetopriscila.model.Animal
import com.example.projetopriscila.model.Cachorro
import com.example.projetopriscila.model.Gato
import com.example.projetopriscila.model.Golfinho

class AnimalAdapter(private val context: Context, private val animals: List<Animal>) : BaseAdapter() {

    override fun getCount(): Int {
        return animals.size
    }

    override fun getItem(position: Int): Any {
        return animals[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_animal, parent, false)

        val animal = animals[position]

        // Referências aos widgets no layout personalizado
        val animalImageView = view.findViewById<ImageView>(R.id.animalImageView)
        val animalNameTextView = view.findViewById<TextView>(R.id.animalNameTextView)
        val animalTypeTextView = view.findViewById<TextView>(R.id.animalTypeTextView)

        // Configurar os valores
        animalNameTextView.text = animal.nome
        animalTypeTextView.text = animal.tipo

        // Definir imagem com base no tipo do animal
        val imageResId = when (animal) {
            is Cachorro -> R.drawable.ic_launcher_foreground // Substitua por uma imagem real no drawable
            is Gato -> R.drawable.ic_launcher_foreground // Substitua por uma imagem real no drawable
            is Golfinho -> R.drawable.ic_launcher_foreground // Substitua por uma imagem real no drawable
            else -> R.drawable.ic_launcher_foreground
        }
        animalImageView.setImageResource(imageResId)

        return view
    }
}
