package com.hahn.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hahn.orgs.dao.ProductDao
import com.hahn.orgs.databinding.ActivityFormProductBinding
import com.hahn.orgs.extensions.tryloadimage
import com.hahn.orgs.model.Product
import com.hahn.orgs.ui.dialog.FormImageDialog
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity() {
    
    private val binding by lazy {
        ActivityFormProductBinding.inflate(layoutInflater)
    }
    private var url: String? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastar Produto"
        confgBtnSave()
        binding.activityFormImageView.setOnClickListener {
            FormImageDialog(this)
                .showDialog(url) { image ->
                    url = image
                    binding.activityFormImageView.tryloadimage(url)
                }
        }
        
    }
    
    private fun confgBtnSave() {
        val btnSave = binding.btnFormSaveProd
        val dao = ProductDao()
        btnSave.setOnClickListener {
            val newProduct = createProduct()
            dao.store(newProduct)
            finish()
        }
    }
    
    private fun createProduct(): Product {
        val inputName = binding.activityFormName
        val inputDescription = binding.activityFormDescription
        val inputPrice = binding.activityFormVal
        val name = inputName.text.toString()
        val descripition = inputDescription.text.toString()
        val priceTxt = inputPrice.text.toString()
        val value = if (priceTxt.isBlank()) BigDecimal.ZERO else BigDecimal(priceTxt)
        
        return Product(
            name = name,
            description = descripition,
            price = value,
            image = url,
        )
    }
}
