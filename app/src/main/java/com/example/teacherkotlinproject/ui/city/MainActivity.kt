package com.example.teacherkotlinproject.ui.city

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherkotlinproject.*
import com.example.teacherkotlinproject.ui.detail_city.CityActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    MainAdapter.Listener {

    //Сделать закругление для ImageView в CityActivity


    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = MainAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
        adapter.updateItems(cityArray)
    }

    override fun onItemClick(item: City) {
//        showToast(this, item.description)
        val intent = Intent(this, CityActivity::class.java)
        intent.putExtra("city", item)
        startActivity(intent)
    }
}