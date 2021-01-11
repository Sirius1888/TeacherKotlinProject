package com.example.teacherkotlinproject.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherkotlinproject.R
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var items = mutableListOf<String>().apply {
        add("John")
        add("Tom")
        add("Andry")
        add("Sara")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main, null, false))
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: String) {
        itemView.name_tv.text = item
    }
}