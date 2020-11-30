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

    var array = mutableListOf<Contact>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contacts, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return array.count()
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = array[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }

    fun addItems(items: MutableList<Contact>) {
        array = items
        notifyDataSetChanged()
    }

    fun addItem(item: Contact) {
        array.add(item)
        contactArray.add(item)
        notifyItemInserted(array.lastIndex)
    }

    fun removeItem(item: Contact) {
        //Выполнить логику удаления
    }

    fun addItemAt(item: Contact, index: Int) {
        //Выполнить логику востановления
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
