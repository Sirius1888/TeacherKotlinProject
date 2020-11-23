package com.example.teacherkotlinproject.ui.city

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherkotlinproject.News
import com.example.teacherkotlinproject.R

class NewsAdapter(private var listener: Listener): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var newsArray = mutableListOf<News>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsArray.size
    }

    fun updateItems(items: MutableList<News>) {
        newsArray = items
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        newsArray.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
    }

    fun restoreItem(item: News, position: Int) {
        newsArray.add(position, item)
        notifyItemRangeChanged(position, itemCount)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = newsArray[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
        holder.itemView.setOnLongClickListener {
            listener.onLongItemClick(item, position)
            true
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image)
        var title: TextView = itemView.findViewById(R.id.title)
        var description: TextView = itemView.findViewById(R.id.description)

        fun bind(item: News) {
            image.setImageResource(item.image)
            title.text = item.title
            description.text = item.description
        }
    }

    interface Listener {
        fun onItemClick(item: News)
        fun onLongItemClick(item: News, position: Int)
    }
}
