package com.hahn.orgs.ui.recyclerView.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hahn.orgs.databinding.ProductItemBinding
import com.hahn.orgs.model.Product

class ProductListAdapter(
    private val context: Context, products: List<Product>
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>()
{

    private val products = products.toMutableList()

    class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root)
    {

        fun bind_Product(product: Product)
        {
            val name = binding.prodItemName
            val description = binding.prodItemDescription
            val price = binding.prodItemPrice
            name.text = product.name
            description.text = product.description
            price.text = product.price.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val inflater = LayoutInflater.from(context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val product = products[position]
        holder.bind_Product(product)
    }

    override fun getItemCount(): Int = products.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(products: List<Product>)
    {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }
}
