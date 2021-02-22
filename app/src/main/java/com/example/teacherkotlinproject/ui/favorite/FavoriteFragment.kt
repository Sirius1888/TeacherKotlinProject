package com.example.teacherkotlinproject.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.data.model.Publication
import com.example.teacherkotlinproject.ui.main.MainRepository
import com.example.teacherkotlinproject.ui.publication.RequestResult
import com.example.teacherkotlinproject.ui.publication.adapter.PublicationAdapter
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment(), PublicationAdapter.ClickListener, RequestResult {

    lateinit var adapter: PublicationAdapter
    private lateinit var repository: MainRepository
    private var publicationsArray = mutableListOf<Publication>()
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
        adapter = PublicationAdapter(this)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        repository = MainRepository(this)
        repository.fetchFavoritePublications()
    }

    override fun onFavoriteClick(item: Publication, position: Int) {
        for (it in publicationsArray) {
            if (it == item) {
                it.isFavorite = !it.isFavorite
                if (it.isFavorite) it.countOfFavorite += 1
                else it.countOfFavorite -= 1
                repository.updateChangeFavoriteState(it)
                adapter.removeItem(position)
            }
        }
    }

    override fun onCommentClick(item: Publication) {
    }

    override fun onDirectClick(item: Publication) {
    }

    override fun onFailure(t: Throwable) {
    }

    override fun <T> onSuccess(result: T) {
        publicationsArray = result as MutableList<Publication>
        adapter.addItems(publicationsArray)
    }
}