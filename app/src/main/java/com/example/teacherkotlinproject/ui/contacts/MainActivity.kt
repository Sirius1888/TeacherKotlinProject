package com.example.teacherkotlinproject.ui.contacts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.helper.ItemSimpleTouch
import com.example.teacherkotlinproject.models.Contact
import com.example.teacherkotlinproject.models.contactArray
import com.example.teacherkotlinproject.ui.detail_contact.DetailContactActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContactsAdapter.OnItemClick {


    //1. Исправить удаление элемента
    //2. Вызвать отображение  SnackBar с возможностью востановить элемент
    //3. Реализовать востановление элемента

    private lateinit var adapter: ContactsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
        addAction()
    }

    private fun setupAdapter() {
        adapter = ContactsAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter.addItems(contactArray)

        val swipeHandler = object : ItemSimpleTouch(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.array.removeAt(direction)
                adapter.notifyDataSetChanged()
                //Вызвать отображение  SnackBar с возможностью востановить элемент
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recycler_view)
    }

    private fun addAction() {
        fab.setOnClickListener {
            showAddingMemberActionDialog()
        }
    }

    fun showAddingMemberActionDialog() {
        val alert = AlertDialog.Builder(this, R.style.NewsDialogStyle)

        val inflater = layoutInflater.inflate(R.layout.alert_add, null)
        alert.setView(inflater)
        val headerTextView: TextView = inflater.findViewById(R.id.header)
        val negativeButton: Button = inflater.findViewById(R.id.negative)
        val positiveButton: Button = inflater.findViewById(R.id.positive)

        val imageEditText: EditText = inflater.findViewById(R.id.image_edit_text)
        val nameEditText: EditText = inflater.findViewById(R.id.name_edit_text)
        val lastNameEdiText: EditText = inflater.findViewById(R.id.lastname_edit_text)
        val emailEditText: EditText = inflater.findViewById(R.id.email_edit_text)

        val dialog = alert.create()
        headerTextView.text = "Добавление контакта"
        negativeButton.text = "Отменить"
        positiveButton.text = "Добавить"
        negativeButton.setOnClickListener {
            dialog.dismiss()
        }
        positiveButton.setOnClickListener {
            addNewContact(imageEditText, nameEditText, lastNameEdiText, emailEditText, dialog)
        }
        dialog.show()
    }

    private fun addNewContact(imageEditText: EditText, nameEditText: EditText, lastNameEditText: EditText, emailEditText: EditText, dialog: AlertDialog) {
        val image = imageEditText.text.toString()
        val name = nameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()
        val email = emailEditText.text.toString()
        var errorCount = 0

        if (checkIsEmptyField(imageEditText)) errorCount +=1
        if (checkIsEmptyField(nameEditText)) errorCount +=1
        if (checkIsEmptyField(lastNameEditText)) errorCount +=1
        if (checkIsEmptyField(emailEditText)) errorCount +=1

        if (errorCount > 0) return

        adapter.addItem(Contact(image, name, lastName, email))
        dialog.dismiss()
    }

    fun checkIsEmptyField(editText: EditText): Boolean {
        if (editText.text.toString().isEmpty()) {
            editText.error = "Обязательное поле"
            return true
        }
        return false
    }

    override fun onItemClick(item: Contact) {
        val intent = Intent(this, DetailContactActivity::class.java)
        startActivity(intent)
    }

}




