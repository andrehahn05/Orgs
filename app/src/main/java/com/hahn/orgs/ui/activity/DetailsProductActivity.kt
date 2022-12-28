package com.hahn.orgs.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.hahn.orgs.databinding.ActivityProductDetailsBinding

class DetailsProductActivity: AppCompatActivity() {
    private val binding by lazy {
        ActivityProductDetailsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}