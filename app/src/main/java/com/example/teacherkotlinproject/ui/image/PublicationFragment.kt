package com.example.teacherkotlinproject.ui.image

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.helper.showToast
import com.example.teacherkotlinproject.model.Publication
import com.example.teacherkotlinproject.model.publicationsArray
import com.example.teacherkotlinproject.ui.image.adapter.PublicationAdapter
import kotlinx.android.synthetic.main.fragment_image.*


class PublicationFragment : Fragment(),
    PublicationAdapter.ClickListener {

    lateinit var adapter: PublicationAdapter
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
        adapter = PublicationAdapter(this, requireActivity())
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.addItems(publicationsArray)
    }

    override fun onFavoriteClick(item: Publication, position: Int) {
        publicationsArray.forEach {
            if (it == item) it.isFavorite = !it.isFavorite
        }
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


//    var i = 0
//    //Сработает хотя бы 1 раз
//    do {
//        Log.v("DO_WHILE", "COUNT IS $i")
//    } while (i == 0)
//
//    //Сработает ровное количество раз
//    while (i < 3) {
//        Log.v("WHILE", "COUNT IS $i")
//    }
//
//    //Сработает ровное количество раз
//    for (i in 1..3) {
//        Log.v("FOR", "COUNT IS $i")
//    }
}