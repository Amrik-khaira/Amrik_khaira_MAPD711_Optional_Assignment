package com.amrik.myapplication.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amrik.myapplication.listener.ItemSelectListener
import com.amrik.myapplication.Product
import com.amrik.myapplication.R


class CategoryListAdapter(private val context: Context, private val itemSelectListener: ItemSelectListener,
) :
    ListAdapter<Product, CategoryListAdapter.ViewCategoryHolder>(
        ViewCategoryHolder.ViewCategoryDiffUtil
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): ViewCategoryHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_card, parent, false)

        return ViewCategoryHolder(
            context = context,
            itemSelectListener = itemSelectListener,
            view = itemView)
    }

    override fun onBindViewHolder(viewCategoryHolder: ViewCategoryHolder, position: Int) {
        viewCategoryHolder.onBind(getItem(position))
    }

    class ViewCategoryHolder(
        private val context: Context,
        private val itemSelectListener: ItemSelectListener,

        private val view: View
    ) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")

        fun onBind(product: Product) {
           view. findViewById<TextView>(R.id.categoryName).text = product.title
            view.findViewById<TextView>(R.id.categoryBrandNameText).text = product.brand
            view.findViewById<TextView>(R.id.categoryRating).text = product.rating.toString()
            view.findViewById<TextView>(R.id.categoryDetail).text = product.description
            Log.d(" product.title",""+ product.title.toString());
            view.findViewById<TextView>(R.id.viewAll).setOnClickListener {
                itemSelectListener.onItemSelect(product)
            }
        }

        object ViewCategoryDiffUtil : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}

