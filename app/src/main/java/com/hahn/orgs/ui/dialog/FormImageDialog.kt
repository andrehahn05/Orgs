package com.hahn.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.hahn.orgs.databinding.FormImageBinding
import com.hahn.orgs.extensions.tryloadimage

class FormImageDialog(private val context: Context) {
    fun showDialog(
        urlDefault: String? = null,
        handleWhenLoad: (image: String) -> Unit
    ) {
        FormImageBinding
            .inflate(LayoutInflater.from(context)).apply {
                urlDefault?.let {
                    formImageViewImg.tryloadimage(it)
                    formImgUrl.setText(it)
                }
                
                formImgBtnLoad.setOnClickListener {
                    val url: String = formImgUrl.text.toString()
                    formImageViewImg.tryloadimage(url)
                }
        
                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton("Confirmar") { _, _ ->
                        val url = formImgUrl.text.toString()
                        handleWhenLoad(url)
                    }
                    .setNegativeButton("Cancelar") { _, _ ->
                    }
                    .show()
            }
        
    }
}

