package com.example.projetopriscila.model

// Classe abstrata Animal
abstract class Animal(val nome: String, val idade: Int, val tipo: String) {
    abstract fun falar(): String
    open fun info(): String {
        return "Nome: $nome\nIdade: $idade\nTipo: $tipo"
    }
}