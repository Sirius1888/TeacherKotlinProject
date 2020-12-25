package com.example.teacherkotlinproject.ui.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.helper.showSnackbar
import com.example.teacherkotlinproject.models.*
import com.example.teacherkotlinproject.ui.favorites.adapter.FavoritesAdapter
import kotlinx.android.synthetic.main.fragment_cat.*

class FavoritesPetsFragment : Fragment(), FavoritesAdapter.OnItemClick {

    lateinit var adapter: FavoritesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites_pets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    override fun onResume() {
        super.onResume()
        updateItems()
    }

    private fun setupAdapter() {
        adapter = FavoritesAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        recycler_view.adapter = adapter
    }

    private fun updateItems() {
        adapter.addItems(getFavoriteArray())
    }

    override fun onLikeClick(position: Int, item: Pet) {
        adapter.removeItem(position)
        changeItems(item)
        showSnackbar(recycler_view,
            "Вы удалили из избранного ${item.name}",
            "Восстановить")  {
            adapter.restoreItem(position, item)
            changeItems(item) }
    }

    private fun changeItems(item: Pet) {
        changeState(item, dogArray)
        changeState(item, catArray)
    }

}