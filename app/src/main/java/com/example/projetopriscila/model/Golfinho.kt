package com.example.projetopriscila.model

class Golfinho(nome: String, idade: Int) : Animal(nome, idade, "Marinho") {
    override fun falar(): String {
        return "Cli Cli Cli!"
    }
}