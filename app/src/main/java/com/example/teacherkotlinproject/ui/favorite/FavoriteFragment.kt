package com.example.teacherkotlinproject.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.model.Publication
import com.example.teacherkotlinproject.model.publicationsArray
import com.example.teacherkotlinproject.ui.publication.adapter.PublicationAdapter
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment(), PublicationAdapter.ClickListener {

    lateinit var adapter: PublicationAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = PublicationAdapter(this, requireActivity())
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter
//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(rv)
    }

    override fun onResume() {
        super.onResume()
        adapter.addItems(getFavoritesPublications())
    }

    private fun getFavoritesPublications(): MutableList<Publication> {
        return publicationsArray.filter { it.isFavorite } as MutableList<Publication>
    }

    override fun onFavoriteClick(item: Publication, position: Int) {
        publicationsArray.forEach {
            if (it == item) it.isFavorite = !it.isFavorite
        }
        adapter.removeItem(position)
    }

    override fun onCommentClick(item: Publication) {
        TODO("Not yet implemented")
    }

    override fun onDirectClick(item: Publication) {
        TODO("Not yet implemented")
    }

//    override fun onItemClick(item: Publication) {
//
//    }

}