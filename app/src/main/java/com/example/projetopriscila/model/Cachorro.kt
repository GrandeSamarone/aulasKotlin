package com.example.projetopriscila.model

// Classes concretas
class Cachorro(nome: String, idade: Int) : Animal(nome, idade, "Doméstico") {
    override fun falar(): String {
        return "Au Au!"
    }
}