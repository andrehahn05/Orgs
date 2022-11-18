package com.hahn.orgs.dao

import com.hahn.orgs.model.Product

class ProductDao {

    fun store(product:Product) {
        products.add(product)
    }

    fun findAll():List<Product> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>()
    }
}