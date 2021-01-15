package com.example.teacherkotlinproject.ui.image_carousel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.teacherkotlinproject.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_image_carousel.*

class ImageCarouselFragment(private val imageUrl: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image_carousel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Glide.with(this).load(imageUrl).into(image_iv)

        Picasso.get().load(imageUrl).into(image_iv)
    }
}