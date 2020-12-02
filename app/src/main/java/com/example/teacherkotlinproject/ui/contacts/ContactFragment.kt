package com.example.teacherkotlinproject.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.helper.ItemSimpleTouch
import com.example.teacherkotlinproject.helper.OnAddEditListener
import com.example.teacherkotlinproject.helper.ShowAddEditingDialog
import com.example.teacherkotlinproject.helper.showSnackbar
import com.example.teacherkotlinproject.models.Contact
import com.example.teacherkotlinproject.models.contactArray
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment(), ContactsAdapter.OnItemClick, OnAddEditListener {

    //1. Прочитать про fragments
    //2. Прочитать про класс Dialog
    //3. Прочитать про toolbar
    //4. ContactDetailFragment добавить тулбар, и добавить кнопку и сделать удаление элемента из contactArray и закрывать активити.

    lateinit var adapter: ContactsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupAdapter()
        addAction()
    }

    private fun setupAdapter() {
        adapter = ContactsAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(requireContext())

        val swipeHandler = object : ItemSimpleTouch(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val contact = contactArray[position]
                adapter.removeItem(position)
                showSnackbar(fab, "Вы удалили контакт", "Востановить") { adapter.restoreItem(position, contact) }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recycler_view)
    }

    override fun onItemClick(item: Contact) {
        val bundle = Bundle()
        bundle.putSerializable("item", item)

        val fragment = ContactDetailFragment()
        fragment.arguments = bundle

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container_fragment, fragment, fragment.tag)
            ?.addToBackStack(fragment.tag)
            ?.commit()
    }

    private fun addAction() {
        fab.setOnClickListener {
            activity?.let {
                ShowAddEditingDialog(it, "Добавление контакта", this, 0).show()
            }
        }
    }

    override fun addEditingDialog(type: Int, contact: Contact) {
        adapter.addItem(contact)
    }
}