package com.hahn.orgs.dao

import com.hahn.orgs.model.Product
import java.math.BigDecimal

class ProductDao
{

    fun store(product: Product)
    {
        products.add(product)
    }

    fun findAll(): List<Product>
    {
        return products.toList()
    }

    companion object
    {
        private val products = mutableListOf<Product>(
            Product(
                name = "Frutas",
                description = "um pouco de tudo",
                price = BigDecimal("39.49")
            )
        )
    }
}