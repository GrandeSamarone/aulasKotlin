package com.example.projetopriscila.model

class Gato(nome: String, idade: Int) : Animal(nome, idade, "Doméstico") {
    override fun falar(): String {
        return "Miau!"
    }
}