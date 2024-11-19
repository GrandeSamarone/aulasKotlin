package com.example.projetopriscila.functions

import androidx.appcompat.widget.AppCompatEditText


fun validateFields(vararg fields: AppCompatEditText, validator: (String) -> Boolean): Boolean {
    fields.forEach { field ->
        if (!validator(field.text.toString())) {
            return false
        }
    }
    return true
}