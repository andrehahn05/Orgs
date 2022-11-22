package com.hahn.orgs.ui.recyclerView.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hahn.orgs.databinding.ProductItemBinding
import com.hahn.orgs.model.Product
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class ProductListAdapter(
    private val context: Context, products: List<Product>
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>()
{

    private val products = products.toMutableList()

    class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root)
    {

        fun bindProduct(product: Product)
        {
            val name = binding.prodItemName
            val description = binding.prodItemDescription
            val price = binding.prodItemPrice
            name.text = product.name
            description.text = product.description
            val valueCurrency: String = formatPtBr(product.price)
            price.text = valueCurrency
        }

        private fun formatPtBr(price:BigDecimal): String
        {
            val formatter: NumberFormat = NumberFormat
                .getCurrencyInstance(Locale("pt", "br"))
            return formatter.format(price)
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
        holder.bindProduct(product)
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
