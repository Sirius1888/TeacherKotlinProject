package com.example.teacherkotlinproject.ui.city

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val array = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addToArrayAction()
        removeFromArrayAction()
    }

    private fun addToArrayAction() {
        add.setOnClickListener {
            val value = text_add.text.toString()
            if (value.isEmpty()) {
                showToast(this, resources.getString(R.string.cannot_add_empty))
                return@setOnClickListener
            }
            array.add(value)
            text_add.text.clear()
            showArrayItems()
        }
    }

    private fun removeFromArrayAction() {
        remove.setOnClickListener {
            val value = text_remove.text.toString()
            if (value.isEmpty()) {
                showToast(this, resources.getString(R.string.cannot_remove_empty))
                return@setOnClickListener
            }
            text_remove.text.clear()
            removeFromArray(value)
        }
    }

    private fun removeFromArray(value: String) {
        var deletedIndex: Int? = null
        for ((index, item) in array.withIndex()) {
            if (item == value) deletedIndex = index
        }
        deletedIndex?.let { array.removeAt(it) }
        showArrayItems()
    }

    private fun showArrayItems() {
        var text = ""
        for (item in array) {
            text += "$item \n"
        }
        showToast(this, text)
    }

}