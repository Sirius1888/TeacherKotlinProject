package com.example.teacherkotlinproject.ui.detail_name

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.teacherkotlinproject.R
import kotlinx.android.synthetic.main.activity_detail_name.*

class DetailNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_name)

        val name = intent?.getStringExtra("name_item")
        name_tv.text = "Вы передали элемент $name"
    }
}