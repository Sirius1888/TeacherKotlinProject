package com.example.teacherkotlinproject.ui.pets.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.models.Pet


class PetAdapter(private var listener: OnItemClick) : RecyclerView.Adapter<PetViewHolder>() {

    private var array = mutableListOf<Pet>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)
        return PetViewHolder(view)
    }

    override fun getItemCount(): Int {
        return array.count()
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val item = array[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
        holder.like.setOnClickListener {
            val like = !array[position].isLiked
            array[position].isLiked = like
            holder.like.setImageResource(getLikeImage(like))
        }
    }

    fun addItems(items: MutableList<Pet>) {
        array = items
        notifyDataSetChanged()
    }

    interface OnItemClick {
        fun onItemClick(item: Pet)
    }

}

class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val image: ImageView = itemView.findViewById(R.id.image)
    val title: TextView = itemView.findViewById(R.id.title)
    val subtitle: TextView = itemView.findViewById(R.id.subtitle)
    val like: ImageButton = itemView.findViewById(R.id.like)

    fun bind(item: Pet) {
        Glide.with(image.context)
            .load(item.image)
            .into(image)
        title.text = item.name
        subtitle.text = item.description

        like.setImageResource(getLikeImage(item.isLiked))
    }
}

fun getLikeImage(state: Boolean) = if (state)  R.drawable.ic_like
else R.drawable.ic_unlike