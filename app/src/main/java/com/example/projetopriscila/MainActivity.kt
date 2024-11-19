package com.example.projetopriscila

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextSwitcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetopriscila.activitys.HomeActivity
import com.example.projetopriscila.functions.showToast
import com.example.projetopriscila.functions.validateFields
import model.user.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar:Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val nameEditText = findViewById<AppCompatEditText>(R.id.nameEditText)
        val emailEditText = findViewById<AppCompatEditText>(R.id.emailEditText)
        val passwordEditText = findViewById<AppCompatEditText>(R.id.passwordEditText)
        val cadastroButton = findViewById<Button>(R.id.cadastroButton)

        cadastroButton.setOnClickListener {
            try {
                val user = getUserFromInput(nameEditText, emailEditText, passwordEditText)
                if (user.isValid()) {
                    handleSuccessfulRegistration(user)
                } else {
                    showError("Por favor, preencha todos os campos corretamente!")
                }
            } catch (e: IllegalArgumentException) {
                showError(e.message ?: "Erro inesperado!")
            }
        }


    }


    private fun getUserFromInput(
        nameEditText: AppCompatEditText,
        emailEditText: AppCompatEditText,
        passwordEditText: AppCompatEditText
    ): User {
        val name = nameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (validateFields(nameEditText, emailEditText, passwordEditText) { it.isNotEmpty() }) {
            showMessage("Todos os campos foram preenchidos!")
        }


        return User(name, email, password)
    }

    // Função para lidar com o sucesso
    private fun handleSuccessfulRegistration(user: User) {
        // Redirecionar para a nova tela
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("USER_NAME", user.name)
        startActivity(intent)
        finish() // Fecha a tela de cadastro
    }


    // Função para exibir mensagens de erro
    private fun showError(message: String) {
      //  Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        showToast(this,message)
    }

    // Função para exibir mensagens de sucesso
    private fun showMessage(message: String) {
       // Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        showToast(this,message)
    }





}

