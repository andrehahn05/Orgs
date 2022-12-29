package com.hahn.orgs.ui.activity

import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.hahn.orgs.databinding.ActivityProductDetailsBinding
import com.hahn.orgs.extensions.formatPtBr
import com.hahn.orgs.extensions.tryloadimage
import com.hahn.orgs.model.Product
import kotlinx.parcelize.parcelableCreator

class DetailsProductActivity : AppCompatActivity() {
    
    private val binding by lazy {
        ActivityProductDetailsBinding.inflate(layoutInflater)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        tryLoadProduct()
    }
    
    //@Suppress("DEPRECATION")
    private fun tryLoadProduct() {
        intent.getParcelableExtra<Product>(KEY_PRODUCT)?.let { loadedProduct ->
            bind(loadedProduct)
        } ?: finish()
    }
    
    private fun bind(loadedProduct: Product) {
        with(binding) {
            activityDetailsProductImage.tryloadimage(loadedProduct.image)
            activityDetailsProductName.text = loadedProduct.name
            activityDetailsProductDescription.text = loadedProduct.description
            activityDetailsProductValue.text = loadedProduct.price.formatPtBr()
        }
    }
}