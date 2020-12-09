package com.example.teacherkotlinproject.helper

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import com.example.teacherkotlinproject.R
import kotlinx.android.synthetic.main.alert_add.*

class ShowAddEditingDialog(context: Context, var headerTitle: String,
                           var listener: OnAddEditListener, var type: Int): Dialog(context, R.style.NewsDialogStyle) {

    //type 0 - add, 1 - edit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alert_add)
        setupViews()
        negativeAction()
        positiveAction()
    }

    private fun setupViews() {
        header.text = headerTitle
    }

    private fun negativeAction() {
        negative.setOnClickListener { dismiss() }
    }

    private fun positiveAction() {
        positive.setOnClickListener {
            var errorCount = 0
            if (checkIsEmptyField(image_edit_text)) errorCount +=1
            if (checkIsEmptyField(name_edit_text)) errorCount +=1
            if (checkIsEmptyField(lastname_edit_text)) errorCount +=1
            if (checkIsEmptyField(email_edit_text)) errorCount +=1

            if (errorCount > 0) return@setOnClickListener

//            val contact = Contact(
//                image_edit_text.text.toString(),
//                name_edit_text.text.toString(),
//                lastname_edit_text.text.toString(),
//                email_edit_text.text.toString())
//            listener.addEditingDialog(type, contact)
            dismiss()
        }
    }
}

fun checkIsEmptyField(editText: EditText): Boolean {
    if (editText.text.toString().isEmpty()) {
        editText.error = "Обязательное поле"
        return true
    }
    return false
}

interface OnAddEditListener {
//    fun addEditingDialog(type: Int, contact: Contact)
}