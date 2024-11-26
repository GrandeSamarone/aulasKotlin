package com.example.projetopriscila.activitys
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.projetopriscila.R

class CollectionsActivity : AppCompatActivity() {
    private val itemList = mutableListOf("Maçã", "Banana", "Laranja", "Melancia", "Morango")
    private val itemSet = mutableSetOf<String>()
    private val itemMap = mutableMapOf("maçã" to 1.0, "banana" to 0.5, "laranja" to 0.8)
    private var isAddingMode = true // Variável para alternar entre modos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collections)

        val listView = findViewById<ListView>(R.id.listView)
        val actionEditText = findViewById<EditText>(R.id.addItemEditText)
        val actionButton = findViewById<Button>(R.id.addItemButton)
        val toggleModeButton = findViewById<Button>(R.id.filterButton)
        val showSetButton = findViewById<Button>(R.id.showSetButton)
        val mapTextView = findViewById<TextView>(R.id.mapTextView)

        // Configurar ListView com adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
        listView.adapter = adapter

        // Alternar entre modos
        toggleModeButton.setOnClickListener {
            isAddingMode = !isAddingMode
            if (isAddingMode) {
                actionEditText.hint = "Adicionar item"
                actionButton.text = "Adicionar Item"
            } else {
                actionEditText.hint = "Digite uma letra para filtrar"
                actionButton.text = "Filtrar Itens"
            }
        }

        // Botão que funciona como "Adicionar" ou "Filtrar"
        actionButton.setOnClickListener {
            val input = actionEditText.text.toString().trim()
            if (isAddingMode) {

                // Adicionar item
                if (input.isNotEmpty()) {
                    itemList.add(input)
                    itemSet.add(input)
                    adapter.notifyDataSetChanged()
                    actionEditText.text.clear()
                    Toast.makeText(this, "$input adicionado!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Digite um item válido!", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Filtrar itens
                if (input.length == 1) {
                    val filteredList = itemList.filter { it.startsWith(input, ignoreCase = true) }
                    if (filteredList.isNotEmpty()) {
                        adapter.clear()
                        adapter.addAll(filteredList)
                        adapter.notifyDataSetChanged()
                        Toast.makeText(this, "Itens filtrados pela letra '$input': $filteredList", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Nenhum item encontrado com a letra '$input'", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Digite apenas uma letra!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Mostrar conjunto de itens únicos
        showSetButton.setOnClickListener {
            val uniqueItems = itemSet.joinToString(", ")
            if (uniqueItems.isNotEmpty()) {
                Toast.makeText(this, "Itens únicos: $uniqueItems", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Nenhum item único encontrado!", Toast.LENGTH_SHORT).show()
            }
        }

        // Mostrar o conteúdo do mapa
        val formattedMap = itemMap.map { "${it.key}: R$${it.value}" }.joinToString("\n")
        mapTextView.text = "Mapa de preços:\n$formattedMap"
    }
}

