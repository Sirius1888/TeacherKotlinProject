package com.example.teacherkotlinproject.ui.detail_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teacherkotlinproject.News
import com.example.teacherkotlinproject.R
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        val item = intent?.getSerializableExtra("news_item") as News
        setupViews(item)
    }

    private fun setupViews(item: News) {
        image.setImageResource(item.image)
        header.text = item.title
        description.text = item.description
    }

}