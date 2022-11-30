package com.hahn.orgs.extensions

import android.widget.ImageView
import coil.load
import com.hahn.orgs.R

fun ImageView.tryloadimage(url: String? = null) {
        load(url) {
            fallback(R.drawable.erro)
            error(R.drawable.erro)
            placeholder(R.drawable.placeholder)
        }
}