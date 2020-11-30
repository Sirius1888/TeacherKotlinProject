package com.example.teacherkotlinproject.helper
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.models.Contact
import kotlinx.android.synthetic.main.alert_add.*

fun showSingleActionDialog(action: () -> Unit, activity: AppCompatActivity, header: String, positive: String, negative: String) {
    val alert = AlertDialog.Builder(activity, R.style.NewsDialogStyle)

    val inflater = activity.layoutInflater.inflate(R.layout.alert_delete, null)
    alert.setView(inflater)
    val headerTextView: TextView = inflater.findViewById(R.id.header)
    val negativeButton: Button = inflater.findViewById(R.id.negative)
    val positiveButton: Button = inflater.findViewById(R.id.positive)
    val dialog = alert.create()
    headerTextView.text = header
    negativeButton.text = positive
    positiveButton.text = negative
    negativeButton.setOnClickListener {
        dialog.dismiss()
    }
    positiveButton.setOnClickListener {
        action()
        dialog.dismiss()
    }
    dialog.show()
}

class ShowAddEditingDialog(context: Context, var headerTitle: String, var listener: OnAddEditListener, var type: Int): Dialog(context, R.style.NewsDialogStyle) {

    //type 0 - add, 1 - edit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alert_add)
        header.text = headerTitle
        negative.setOnClickListener { dismiss() }
        positive.setOnClickListener { listener.addEditingDialog(type, Contact(
            image_edit_text.text.toString(),
            name_edit_text.text.toString(),
            lastname_edit_text.text.toString(),
            email_edit_text.text.toString())
        )}
    }

}

interface OnAddEditListener {
    fun addEditingDialog(type: Int, contact: Contact)
}


