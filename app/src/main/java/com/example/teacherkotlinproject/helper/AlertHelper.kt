package com.example.teacherkotlinproject.helper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.teacherkotlinproject.R

fun showSingleActionDialog(action: () -> Unit, activity: AppCompatActivity, header: String, positive: String, negative: String) {
    val alert = AlertDialog.Builder(activity, R.style.NewsDialogStyle)
//
//    val inflater = activity.layoutInflater.inflate(R.layout.alert_delete, null)
//    alert.setView(inflater)
//    val headerTextView: TextView = inflater.findViewById(R.id.header)
//    val negativeButton: Button = inflater.findViewById(R.id.negative)
//    val positiveButton: Button = inflater.findViewById(R.id.positive)
//    val dialog = alert.create()
//    headerTextView.text = header
//    negativeButton.text = positive
//    positiveButton.text = negative
//    negativeButton.setOnClickListener {
//        dialog.dismiss()
//    }
//    positiveButton.setOnClickListener {
//        action()
//        dialog.dismiss()
//    }
//    dialog.show()
}