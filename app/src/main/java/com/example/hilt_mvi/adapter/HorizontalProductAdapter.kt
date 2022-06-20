package com.example.hilt_mvi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hilt_mvi.databinding.ItemHorizontalBinding
import com.example.hilt_mvi.model.Product


class HorizontalProductAdapter(
    ): ListAdapter<Product, HorizontalProductAdapter.HorizontalProductViewHolder>(ProductDiffCallback()) {
    class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
     class HorizontalProductViewHolder constructor(
         private val binding: ItemHorizontalBinding
     ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(product: Product ) = with(itemView) {
            binding.product = product
            binding.executePendingBindings()

            //Notify the listener on item click

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
       val binding=ItemHorizontalBinding.inflate(
           layoutInflater,
           parent,
           false
       )
        return HorizontalProductViewHolder(
            binding
        )
    }


    override fun onBindViewHolder(holder: HorizontalProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }












}


