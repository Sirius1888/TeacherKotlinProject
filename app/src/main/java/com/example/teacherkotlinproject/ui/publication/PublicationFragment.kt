package com.example.teacherkotlinproject.ui.publication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.model.Publication
import com.example.teacherkotlinproject.model.publicationsArray
import com.example.teacherkotlinproject.ui.publication.adapter.PublicationAdapter
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
//        var a: Int
//        public const val MIN_VALUE: Int = -2147483648
//        public const val MAX_VALUE: Int = 2147483647
        var b: Long
//        public const val MIN_VALUE: Long = -9223372036854775807L - 1L
//        public const val MAX_VALUE: Long = 9223372036854775807L
        adapter = PublicationAdapter(this)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
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

//        it.countOfFavorite -= 1
//        it.countOfFavorite = it.countOfFavorite - 1
    }

    override fun onCommentClick(item: Publication) {

    }

    override fun onDirectClick(item: Publication) {

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