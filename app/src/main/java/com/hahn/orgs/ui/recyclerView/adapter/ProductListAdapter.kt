package com.hahn.orgs.ui.recyclerView.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hahn.orgs.databinding.ProductItemBinding
import com.hahn.orgs.extensions.formatPtBr
import com.hahn.orgs.extensions.tryloadimage
import com.hahn.orgs.model.Product
import java.util.*

class ProductListAdapter(
    private val context: Context,
    products: List<Product>,
    var handlerClickOnItem: (product: Product) -> Unit = {}
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {
    
    private val products = products.toMutableList()
    
    inner class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        
        private lateinit var product: Product
        init {
            itemView.setOnClickListener {
                if (::product.isInitialized) {
                    handlerClickOnItem(product)
                }
            }
        }
        
        fun bindProduct(product: Product) {
            this.product = product
            val name = binding.prodItemName
            val description = binding.prodItemDescription
            val price = binding.prodItemPrice
            name.text = product.name
            description.text = product.description
            val valueCurrency: String = product.price.formatPtBr()
            price.text = valueCurrency
            
            val visibility = if (product.image != null) View.VISIBLE else View.GONE
            
            binding.imageView.visibility = visibility
            
            binding.imageView.tryloadimage(product.image)
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bindProduct(product)
    }
    
    override fun getItemCount(): Int = products.size
    
    @SuppressLint("NotifyDataSetChanged")
    fun update(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }
}
