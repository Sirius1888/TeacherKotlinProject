package com.example.teacherkotlinproject.ui.contacts

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.helper.ItemSimpleTouch
import com.example.teacherkotlinproject.helper.OnAddEditListener
import com.example.teacherkotlinproject.helper.ShowAddEditingDialog
import com.example.teacherkotlinproject.helper.showToast
import com.example.teacherkotlinproject.models.Contact
import com.example.teacherkotlinproject.models.contactArray
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment(), ContactsAdapter.OnItemClick, OnAddEditListener {

    //1. Прочитать про fragments
    //2. Прочитать про класс Dialog
    //3. Исправить пропавшие кнопки
    //4. Прочитать про toolbar
    //5. (Extra) ContactDetailFragment добавить тулбар, и добавить кнопку и сделать удаление элемента из contactArray

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
        adapter.addItems(contactArray)


        val swipeHandler = object : ItemSimpleTouch(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.array.removeAt(direction)
                adapter.notifyDataSetChanged()
                //Вызвать отображение  SnackBar с возможностью востановить элемент
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

//    fun showAddingMemberActionDialog() {
//        val alert = AlertDialog.Builder(requireContext(), R.style.NewsDialogStyle)
//
//        val inflater = layoutInflater.inflate(R.layout.alert_add, null)
//        alert.setView(inflater)
//        val headerTextView: TextView = inflater.findViewById(R.id.header)
//        val negativeButton: Button = inflater.findViewById(R.id.negative)
//        val positiveButton: Button = inflater.findViewById(R.id.positive)
//
//        val imageEditText: EditText = inflater.findViewById(R.id.image_edit_text)
//        val nameEditText: EditText = inflater.findViewById(R.id.name_edit_text)
//        val lastNameEdiText: EditText = inflater.findViewById(R.id.lastname_edit_text)
//        val emailEditText: EditText = inflater.findViewById(R.id.email_edit_text)
//
//        val dialog = alert.create()
//        headerTextView.text = "Добавление контакта"
//        negativeButton.text = "Отменить"
//        positiveButton.text = "Добавить"
//        negativeButton.setOnClickListener {
//            dialog.dismiss()
//        }
//        positiveButton.setOnClickListener {
//            addNewContact(imageEditText, nameEditText, lastNameEdiText, emailEditText, dialog)
//        }
//        dialog.show()
//    }
//
//    private fun addNewContact(imageEditText: EditText, nameEditText: EditText, lastNameEditText: EditText, emailEditText: EditText, dialog: AlertDialog) {
//        val image = imageEditText.text.toString()
//        val name = nameEditText.text.toString()
//        val lastName = lastNameEditText.text.toString()
//        val email = emailEditText.text.toString()
//        var errorCount = 0
//
//        if (checkIsEmptyField(imageEditText)) errorCount +=1
//        if (checkIsEmptyField(nameEditText)) errorCount +=1
//        if (checkIsEmptyField(lastNameEditText)) errorCount +=1
//        if (checkIsEmptyField(emailEditText)) errorCount +=1
//
//        if (errorCount > 0) return
//        adapter.addItem(Contact(image, name, lastName, email))
//        dialog.dismiss()
//    }

    fun checkIsEmptyField(editText: EditText): Boolean {
        if (editText.text.toString().isEmpty()) {
            editText.error = "Обязательное поле"
            return true
        }
        return false
    }

    override fun addEditingDialog(type: Int, contact: Contact) {
        adapter.addItem(contact)
    }
}