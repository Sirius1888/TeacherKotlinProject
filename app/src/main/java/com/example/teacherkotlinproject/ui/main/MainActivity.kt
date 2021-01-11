package com.example.teacherkotlinproject.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.ui.main.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Сделать нажатие на элемент и переход на следующее активити
    lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = MainAdapter()
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
    }

}