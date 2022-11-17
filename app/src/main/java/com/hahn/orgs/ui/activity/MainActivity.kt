package com.hahn.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView

import com.hahn.orgs.R
import com.hahn.orgs.model.Product
import com.hahn.orgs.ui.recyclerView.adapter.ProductListAdapter
import java.math.BigDecimal

class MainActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView =  findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ProductListAdapter( context = this, products = listOf(
            Product(
                name = "Cesta de Frutas",
                description = "Laranja,banana e goiaba",
                price = BigDecimal(19.59)
            ),
            Product(
                name = "Cesta salada",
                description = "pepino, tomate, alface e repower",
                price = BigDecimal(12.59)
            ),
            Product(
                name = "Cesta de Frutas 02",
                description = "Laranja,banana,goiaba, melancia,jaca, manga d tudo um pouco",
                price = BigDecimal(39.59)
            ),
        ))

       recyclerView.layoutManager = LinearLayoutManager(this)
    }
}