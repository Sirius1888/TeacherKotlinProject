package com.example.teacherkotlinproject.ui.pets.dog

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
import com.example.teacherkotlinproject.ui.pets.adapter.PetAdapter
import com.example.teacherkotlinproject.ui.pets.pet_detail.PetDetailActivity
import kotlinx.android.synthetic.main.fragment_cat.*

class DogFragment : Fragment(), PetAdapter.OnItemClick {

    lateinit var adapter: PetAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = PetAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(activity?.applicationContext)
    }

    override fun onResume() {
        super.onResume()
        updateItems()
    }

    private fun updateItems() {
        adapter.addItems(dogArray)
    }

    override fun onItemClick(item: Pet) {
        val intent = Intent(activity, PetDetailActivity::class.java)
        intent.putExtra("pet", item)
        startActivity(intent)
    }

}