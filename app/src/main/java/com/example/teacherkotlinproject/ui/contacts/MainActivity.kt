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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}