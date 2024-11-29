package com.example.projetopriscila.repository

import com.example.projetopriscila.model.Animal

object AnimalRepository {
    private val animals = mutableListOf<Animal>()

    fun addAnimal(animal: Animal) {
        animals.add(animal)
    }

    fun getAnimals(): List<Animal> {
        return animals
    }

    fun getAnimal(index: Int): Animal? {
        return if (index in animals.indices) animals[index] else null
    }
}
