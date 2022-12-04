package com.hahn.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.hahn.orgs.databinding.FormImageBinding
import com.hahn.orgs.extensions.tryloadimage

class FormImageDialog(private val context: Context) {
    fun showDialog(handleWhenLoad: (image: String) -> Unit) {
        val binding = FormImageBinding.inflate(LayoutInflater.from(context))
        binding.formImgBtnLoad.setOnClickListener {
            val url: String = binding.formImgUrl.text.toString()
            binding.formImageViewImg.tryloadimage(url)
        }
        
        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("Confirmar") { _, _ ->
                val url = binding.formImgUrl.text.toString()
                handleWhenLoad(url)
            }
            .setNegativeButton("Cancelar") { _, _ ->
            }
            .show()
    }
}

