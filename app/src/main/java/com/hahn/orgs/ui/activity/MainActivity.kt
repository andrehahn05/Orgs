package com.hahn.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hahn.orgs.R
import com.hahn.orgs.ui.recyclerView.adapter.ProductListAdapter

class MainActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView =  findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ProductListAdapter()

//        val product =   findViewById<TextView>(R.id.txtView_product)
//        val description =   findViewById<TextView>(R.id.txtView_description)
//        val price =   findViewById<TextView>(R.id.txtView_price)
//
//        product.text = "Cesta de Frutas"
//        description.text = "Laranja,banana e goiaba"
//        price.text = "22.59"
    }
}