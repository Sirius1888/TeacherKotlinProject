package com.example.teacherkotlinproject.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.teacherkotlinproject.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onStart() {
        super.onStart()
        Glide.with(image.context)
            .load("https://knowhow.pp.ua/wp-content/uploads/2020/05/unnamed-2.jpg")
            .into(image)
        name.setText("Tim")
        surname.setText("Cook")
        phone_number.setText("+996555555000")
    }
}