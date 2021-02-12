package com.example.teacherkotlinproject.ui.publication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.model.Comment
import com.example.teacherkotlinproject.model.Images
import kotlinx.android.synthetic.main.item_comments.view.*
import kotlinx.android.synthetic.main.item_image.view.*

class CommentsPublicationAdapter : RecyclerView.Adapter<CommentsPublicationViewHolder>() {

    private var urls = mutableListOf<Comment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsPublicationViewHolder {
        return CommentsPublicationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_comments, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return urls.count()
    }

    override fun onBindViewHolder(holder: CommentsPublicationViewHolder, position: Int) {
        val item = urls[position]
        holder.bind(item)

    }

    fun addItems(items: MutableList<Comment>) {
        urls = items
        notifyDataSetChanged()
    }

}

class CommentsPublicationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(data: Comment?) {
        itemView.author_tv.text = data?.name
        itemView.comment_tv.text = data?.message
    }
}