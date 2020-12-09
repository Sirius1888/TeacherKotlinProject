package com.example.teacherkotlinproject.ui.cat_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.models.Pet
import kotlinx.android.synthetic.main.activity_cat_detail.*

class CatDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_detail)
        val item = intent.getSerializableExtra("cat") as Pet
        setupViews(item)
    }

    private fun setupViews(item: Pet) {
        Glide.with(this)
            .load(item.image)
            .into(image)

        header.text = item.name
        subtitle.text = item.description
        val likeDrawable = if (item.isLiked) R.drawable.ic_like
        else R.drawable.ic_unlike
        like.setImageResource(likeDrawable)
    }
}