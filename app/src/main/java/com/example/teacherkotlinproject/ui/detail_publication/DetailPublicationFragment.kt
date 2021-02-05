package com.example.teacherkotlinproject.ui.detail_publication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.model.Publication
import com.example.teacherkotlinproject.ui.publication.adapter.setupImagesRecyclerView
import kotlinx.android.synthetic.main.fragment_detail_publication.*

class DetailPublicationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_publication, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getSerializable("publication") as Publication

        Glide.with(requireContext()).load(data.icon).into(icon_civ)
        name_tv.text = data.name
        count_of_favorite_tv.text = "${data.countOfFavorite}"
        setupImagesRecyclerView(data.images, images_rv, rv_pi)
    }
}