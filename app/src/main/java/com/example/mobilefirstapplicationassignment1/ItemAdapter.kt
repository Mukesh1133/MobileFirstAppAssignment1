package com.example.mobilefirstapplicationassignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobilefirstapplicationassignment1.databinding.ItemListBinding

class ItemAdapter(
    private val list: ArrayList<DataModel>,
    private val listener: (position: Int) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.txtName.text = list[position].name
        var url: String = list[position].image
        Glide.with(holder.binding.imgUser.context).load(url).into(holder.binding.imgUser)
        holder.itemView.setOnClickListener {
            listener.invoke(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}