package com.hahn.orgs.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.hahn.orgs.R
import com.hahn.orgs.model.Product
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product) {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val btnSave = findViewById<Button>(R.id.btn_save_prod)
        btnSave.setOnClickListener {
            val inputName = findViewById<EditText>(R.id.edit_name)
            val inputDescription = findViewById<EditText>(R.id.edit_descripition)
            val inputPrice = findViewById<EditText>(R.id.edit_val)

            val name = inputName.text.toString()
            val descripition = inputDescription.text.toString()
            val priceTxt = inputPrice.text.toString()
            val value = if(priceTxt.isBlank()) BigDecimal.ZERO else BigDecimal(priceTxt)

            val newProduct = Product(
                name = name,
                description = descripition,
                price = value
            )
              Log.i("Form:","oncreate:  $newProduct")
        }
    }
}