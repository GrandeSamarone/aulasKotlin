package com.example.projetopriscila.activitys


import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.example.projetopriscila.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Boas-vindas
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)

        // Recupera o nome do usuário da Intent
        val userName = intent.getStringExtra("USER_NAME")
        welcomeTextView.text = "Bem-vindo, $userName!"

        // Número de telefone
        val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
        val confirmButton = findViewById<Button>(R.id.confirmButton)

        // Switch para notificações
        val notificationsSwitch = findViewById<SwitchCompat>(R.id.notificationsSwitch)
        val notificationStatusTextView = findViewById<TextView>(R.id.notificationStatusTextView)

        // Validação do número de telefone
        confirmButton.setOnClickListener {
            val phoneNumber = phoneEditText.text.toString().trim()
            if (isValidPhoneNumber(phoneNumber)) {
                Toast.makeText(this, "Número confirmado: $phoneNumber", Toast.LENGTH_SHORT).show()
            } else {
                phoneEditText.error = "Número de telefone inválido! Use o formato (XX) XXXXX-XXXX."
            }
        }

        // Controle de notificações
        notificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                notificationStatusTextView.text = "Notificações ativadas"
            } else {
                notificationStatusTextView.text = "Notificações desativadas"
            }
        }

        val goToCollectionsButton = findViewById<Button>(R.id.goToCollectionsButton)
        val goToWidgetsButton = findViewById<Button>(R.id.goToWidgetsButton)

        // Botão para abrir a tela de coleções
        goToCollectionsButton.setOnClickListener {
            val intent = Intent(this, CollectionsActivity::class.java)
            startActivity(intent)
        }

        // Botão para abrir a tela de widgets
        goToWidgetsButton.setOnClickListener {
            val intent = Intent(this, WidgetsActivity::class.java)
            startActivity(intent)
        }
    }

    // Função para validar número de telefone no formato (XX) XXXXX-XXXX
    private fun isValidPhoneNumber(phone: String): Boolean {
        val regex = Regex("^\\(\\d{2}\\) \\d{5}-\\d{4}\$")
        return phone.matches(regex)
    }
}
