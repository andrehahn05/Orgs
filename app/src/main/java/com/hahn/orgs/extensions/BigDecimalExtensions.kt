package com.hahn.orgs.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

 fun BigDecimal.formatPtBr(): String {
    val formatter: NumberFormat = NumberFormat
        .getCurrencyInstance(Locale("pt", "br"))
    return formatter.format(this)
}