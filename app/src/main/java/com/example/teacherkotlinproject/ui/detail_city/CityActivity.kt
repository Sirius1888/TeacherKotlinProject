package com.example.teacherkotlinproject.ui.detail_city

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teacherkotlinproject.City
import com.example.teacherkotlinproject.R
import com.example.teacherkotlinproject.showToast
import kotlinx.android.synthetic.main.activity_city.*

class CityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
        getIntentData()
    }

    private fun getIntentData() {
        val item = intent.getSerializableExtra("city") as City
        setItemDataToViews(item)
    }

    private fun setItemDataToViews(data: City) {
        image.setImageResource(data.image)
        header.text = data.name
        sub_header.text = data.description
    }
}