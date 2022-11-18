package com.hahn.orgs.ui.recyclerView.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hahn.orgs.R
import com.hahn.orgs.model.Product


class ProductListAdapter(
    private val context: Context,
    private val products: List<Product>
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    class ViewHolder(View: View) : RecyclerView.ViewHolder(View) {
        fun bind_Product(product: Product) {
            val name = itemView.findViewById<TextView>(R.id.txtView_name)
            val description = itemView.findViewById<TextView>(R.id.txtView_description)
            val price = itemView.findViewById<TextView>(R.id.txtView_price)

            name.text =  product.name
            description.text = product.description
            price.text = product.price.toPlainString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =  LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind_Product(product)
    }

    override fun getItemCount(): Int = products.size

}
