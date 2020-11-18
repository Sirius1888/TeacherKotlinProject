package com.example.teacherkotlinproject.ui.city

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherkotlinproject.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsAdapter.Listener {

    //Добавить кнопку в Snackbar
    //Создать DetailNewsActivity
    //При нажатии на кнопку в Snackbar сделать переход на следущую активити
    //Передать все данные в DetailNewsActivity и отобразить их

    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = NewsAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
        adapter.updateItems(newsArray)
    }

    override fun onItemClick(item: News) {
        showSnackbar(recycler_view, item.title)
    }
}

