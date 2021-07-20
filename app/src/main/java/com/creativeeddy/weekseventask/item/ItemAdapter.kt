package com.creativeeddy.weekseventask.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.creativeeddy.weekseventask.databinding.ItemDetailBinding

class ItemAdapter (var items: List<ItemModel>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder> () {
    inner class ItemViewHolder (val binding: ItemDetailBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind (item: ItemModel){
            binding.itemId.text = item.id.toString()
            binding.itemName.text = item.name
            binding.itemPrice.text = item.price.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: ItemDetailBinding = ItemDetailBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size

    }

}