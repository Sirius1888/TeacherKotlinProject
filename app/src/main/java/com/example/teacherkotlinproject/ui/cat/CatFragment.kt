package com.example.teacherkotlinproject.ui.cat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.models.Pet
import com.example.teacherkotlinproject.models.catArray
import com.example.teacherkotlinproject.ui.cat.adapter.CatAdapter
import com.example.teacherkotlinproject.ui.cat_detail.CatDetailActivity
import kotlinx.android.synthetic.main.fragment_cat.*


class CatFragment : Fragment(), CatAdapter.OnItemClick {

    lateinit var adapter: CatAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cat, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = CatAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity?.applicationContext)
        adapter.addItems(catArray)
    }

    override fun onItemClick(item: Pet) {
        val intent = Intent(activity, CatDetailActivity::class.java)
        intent.putExtra("cat", item)
        startActivity(intent)
    }
}