package com.hahn.orgs.ui.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.hahn.orgs.R
import com.hahn.orgs.dao.ProductDao
import com.hahn.orgs.model.Product
import com.hahn.orgs.ui.recyclerView.adapter.ProductListAdapter
import java.math.BigDecimal

class MainActivity: AppCompatActivity(R.layout.activity_main){
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        val recyclerView =  findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ProductListAdapter( context = this, products = ProductDao().findAll())

        val fab  = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener{
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }
}