package com.example.teacherkotlinproject.ui.publication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.helper.showToast
import com.example.teacherkotlinproject.model.Publication
import com.example.teacherkotlinproject.ui.main.MainRepository
import com.example.teacherkotlinproject.ui.publication.adapter.PublicationAdapter
import kotlinx.android.synthetic.main.fragment_image.*

interface RequestResult {
    fun onFailure(t: Throwable)
    fun <T>onSuccess(result: T)
}

class PublicationFragment : Fragment(),
    PublicationAdapter.ClickListener, RequestResult {

    lateinit var adapter: PublicationAdapter

    private var publicationsArray: MutableList<Publication> = mutableListOf()
    private lateinit var repository: MainRepository
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
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
        repository.fetchPublications()
    }

    override fun onFailure(t: Throwable) {
        showToast(requireContext(), t.message.toString())
    }

    override fun <T>onSuccess(result: T) {
        publicationsArray = result as MutableList<Publication>
        adapter.addItems(publicationsArray)
    }

    override fun onFavoriteClick(item: Publication, position: Int) {
        publicationsArray.forEach {
            if (it == item) {
                it.isFavorite = !it.isFavorite
                if (it.isFavorite) it.countOfFavorite += 1
                else it.countOfFavorite -= 1
            }
            adapter.updateItem(position)
        }
    }

    override fun onCommentClick(item: Publication) {

    }

    override fun onDirectClick(item: Publication) {

    }
}