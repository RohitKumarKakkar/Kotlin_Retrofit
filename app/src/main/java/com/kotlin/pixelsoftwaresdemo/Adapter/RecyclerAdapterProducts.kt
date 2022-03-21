package com.kotlin.pixelsoftwaresdemo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlin.pixelsoftwaresdemo.Model.Product
import com.kotlin.pixelsoftwaresdemo.R

class RecyclerAdapterProducts(private val productList: List<Product>) :
    RecyclerView.Adapter<RecyclerAdapterProducts.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.singleton_productlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val productListing = productList[position]
        // holder.imageView.setImageResource(productListing.image)
        holder.title.text = productListing.title
        holder.description.text = productListing.description
        holder.currentprice.text = "${productListing.price} /-"
        Glide.with(holder.itemView.getContext())
            .load(productListing.image)
            .into(holder.imageView)

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return productList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imgView)
        val title: TextView = itemView.findViewById(R.id.name)
        val description: TextView = itemView.findViewById(R.id.description)
        val currentprice: TextView = itemView.findViewById(R.id.currentprice)
        /* val mainprice: TextView = itemView.findViewById(R.id.title)
         val discountinfo: TextView = itemView.findViewById(R.id.title)*/
    }
}