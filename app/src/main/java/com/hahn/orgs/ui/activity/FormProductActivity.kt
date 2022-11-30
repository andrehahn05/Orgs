package com.hahn.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import coil.load
import com.hahn.orgs.R
import com.hahn.orgs.dao.ProductDao
import com.hahn.orgs.databinding.ActivityFormProductBinding
import com.hahn.orgs.databinding.FormImageBinding
import com.hahn.orgs.extensions.tryloadimage
import com.hahn.orgs.model.Product
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity()
{

    private val binding by lazy {
        ActivityFormProductBinding.inflate(layoutInflater)
    }
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        confgBtnSave()
        binding.activityFormImageView.setOnClickListener {
            val bindingForm = FormImageBinding.inflate(layoutInflater)
            bindingForm.formImgBtnLoad.setOnClickListener {
                val url: String = bindingForm.formImgUrl.text.toString()
                bindingForm.formImageViewImg.tryloadimage(url)
            }

            AlertDialog.Builder(this)
                .setView(bindingForm.root)
                .setPositiveButton("Confirmar") { _, _ ->
                    url = bindingForm.formImgUrl.text.toString()
                    binding.activityFormImageView.tryloadimage(url)
                }
                .setNegativeButton("Cancelar") { _, _ ->
                }
                .show()
        }
    }

    private fun confgBtnSave()
    {
        val btnSave = binding.btnFormSaveProd
        val dao = ProductDao()
        btnSave.setOnClickListener {
            val newProduct = createProduct()
            dao.store(newProduct)
            finish()
        }
    }

    private fun createProduct(): Product
    {
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