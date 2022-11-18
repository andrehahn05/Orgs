package com.hahn.orgs.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.hahn.orgs.R
import com.hahn.orgs.dao.ProductDao
import com.hahn.orgs.ui.recyclerView.adapter.ProductListAdapter

class ListProductActivity: AppCompatActivity(R.layout.activity_list_product){

    private  val dao = ProductDao()
    private  val adapter = ProductListAdapter(context = this, products = dao.findAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.findAll())
        confgFab()
    }

    private fun confgFab() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = this.adapter
    }
}