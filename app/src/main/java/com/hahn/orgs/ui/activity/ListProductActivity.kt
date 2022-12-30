package com.hahn.orgs.ui.activity

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.hahn.orgs.dao.ProductDao
import com.hahn.orgs.databinding.ActivityListProductBinding
import com.hahn.orgs.ui.recyclerView.adapter.ProductListAdapter

class ListProductActivity : AppCompatActivity() {
    
    private val dao = ProductDao()
    private val adapter = ProductListAdapter(context = this, products = dao.findAll())
    private val binding by lazy {
        ActivityListProductBinding.inflate(layoutInflater)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configRecyclerView()
    }
    
    override fun onResume() {
        super.onResume()
        adapter.update(dao.findAll())
        confgFab()
    }
    
    private fun confgFab() {
        val fab = binding.activityListProdFab
        fab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }
    
    private fun configRecyclerView() {
        val recyclerView = binding.activityListProdRecyclerView
        recyclerView.adapter = adapter
        adapter.handlerClickOnItem = {
            val intent = Intent(this,
                DetailsProductActivity::class.java
            ).apply {
                putExtra(KEY_PRODUCT, it)
            }
            startActivity(intent)
        }
    }
}