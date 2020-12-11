package com.example.teacherkotlinproject.ui.dog

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.models.Pet
import com.example.teacherkotlinproject.models.dogArray
import com.example.teacherkotlinproject.ui.dog.adapter.DogAdapter
import com.example.teacherkotlinproject.ui.dog_detail.DogDetailActivity
import kotlinx.android.synthetic.main.fragment_cat.*

class DogFragment : Fragment(), DogAdapter.OnItemClick {

    lateinit var adapter: DogAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dog, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = DogAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity?.applicationContext)
        adapter.addItems(dogArray)
    }

    override fun onItemClick(item: Pet) {
        val intent = Intent(activity, DogDetailActivity::class.java)
        intent.putExtra("dog", item)
        startActivity(intent)
    }

}