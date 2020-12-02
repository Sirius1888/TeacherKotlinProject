package com.example.teacherkotlinproject.ui.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.models.Contact
import com.example.teacherkotlinproject.models.contactArray


class ContactsAdapter(private var listener: OnItemClick) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contacts, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactArray.count()
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = contactArray[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }

    fun addItem(item: Contact) {
        contactArray.add(item)
        notifyItemInserted(contactArray.lastIndex)
    }

    fun restoreItem(position: Int, item: Contact) {
        contactArray.add(position, item)
        notifyItemInserted(position)
        notifyItemRangeChanged(position, itemCount)
    }

    fun removeItem(position: Int) {
        contactArray.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val icon: ImageView = itemView.findViewById(R.id.icon)
        private val firstName: TextView = itemView.findViewById(R.id.firstName)
        private val lastName: TextView = itemView.findViewById(R.id.lastName)

        fun bind(item: Contact) {
            Glide.with(icon.context)
                .load(item.image)
                .placeholder(R.drawable.ic_people)
                .into(icon)

            firstName.text = item.firstName
            lastName.text = item.lastName
        }
    }
    
    interface OnItemClick {
        fun onItemClick(item: Contact)
    }
}
